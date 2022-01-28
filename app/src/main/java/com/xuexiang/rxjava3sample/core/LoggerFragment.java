/*
 * Copyright (C) 2022 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.xuexiang.rxjava3sample.core;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

import com.xuexiang.xui.widget.textview.LoggerTextView;
import com.xuexiang.xutil.common.StringUtils;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

/**
 * 自动注销订阅的fragment
 */
public abstract class LoggerFragment<Binding extends ViewBinding> extends BaseFragment<Binding> implements ILogPrinter {

    protected Disposable disposable;

    protected CompositeDisposable disposablePool;

    public void setDisposable(Disposable disposable) {
        this.disposable = disposable;
    }

    protected boolean isOperationNotDisposed() {
        return disposable != null && !disposable.isDisposed();
    }

    public void addDisposable(Disposable disposable) {
        if (disposablePool == null) {
            disposablePool = new CompositeDisposable();
        }
        disposablePool.add(disposable);
    }

    @Override
    public void onDestroyView() {
        cancelSubscribe();
        cancelSubscribePool();
        super.onDestroyView();
    }

    /**
     * 取消订阅
     */
    protected void cancelSubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    /**
     * 取消订阅池订阅
     */
    protected void cancelSubscribePool() {
        if (disposablePool != null && !disposablePool.isDisposed()) {
            disposablePool.dispose();
        }
    }

    @NonNull
    protected <T> Disposable doSubscribe(@NonNull Observable<T> observable) {
        return observable.subscribe(item -> printNormal(StringUtils.toString(item)), error -> printError(error.getMessage()),
                () -> printSuccess("Completed!"));
    }

    @NonNull
    protected <T> Disposable doSubscribe(@NonNull Observable<T> observable, @NonNull Consumer<? super T> onNext) {
        return observable.subscribe(onNext, error -> printError(error.getMessage()),
                () -> printSuccess("Completed!"));
    }

    @NonNull
    protected <T> Disposable doSubscribe(@NonNull Observable<T> observable, @NonNull Consumer<? super T> onNext, @NonNull Action onComplete) {
        return observable.subscribe(onNext, error -> printError(error.getMessage()), onComplete);
    }

    @NonNull
    protected <T> Disposable doSingleSubscribe(@NonNull Single<T> single) {
        return single.subscribe(item -> printNormal(StringUtils.toString(item)), error -> printError(error.getMessage()));
    }

    @NonNull
    protected <T> Disposable doMaybeSubscribe(@NonNull Maybe<T> maybe) {
        return maybe.subscribe(item -> printNormal(StringUtils.toString(item)), error -> printError(error.getMessage()),
                () -> printSuccess("Completed!"));
    }

    @NonNull
    protected Disposable doCompletableSubscribe(@NonNull Completable completable) {
        return completable.subscribe(() -> printSuccess("Completed!"), error -> printError(error.getMessage()));
    }

    protected <T> void doSubscribe(@NonNull Observable<T> observable, @NonNull LogObserver<T> observer) {
        observable.subscribe(observer);
        addDisposable(observer);
    }

    /**
     * 添加普通日志
     *
     * @param logContent 日志内容
     */
    @Override
    public void printNormal(String logContent) {
        getLogger().logNormal(logContent);
    }

    /**
     * 添加分割线
     */
    @Override
    public void println() {
        getLogger().logNormal("------------------------------------------------------------");
    }

    /**
     * 添加成功日志
     *
     * @param logContent 日志内容
     */
    @Override
    public void printSuccess(String logContent) {
        getLogger().logSuccess(logContent);
    }


    /**
     * 添加警告日志
     *
     * @param logContent 日志内容
     */
    @Override
    public void printWarning(String logContent) {
        getLogger().logWarning(logContent);
    }

    /**
     * 添加错误日志
     *
     * @param logContent 日志内容
     */
    @Override
    public void printError(String logContent) {
        getLogger().logError(logContent);
    }

    /**
     * 清除日志
     */
    public void clearLog() {
        getLogger().clearLog();
    }


    @NonNull
    protected abstract LoggerTextView getLogger();
}
