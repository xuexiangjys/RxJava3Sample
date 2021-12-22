/*
 * Copyright (C) 2021 xuexiangjys(xuexiangjys@163.com)
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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.xuexiang.rxjava3sample.databinding.FragmentTemplateBinding;
import com.xuexiang.xaop.annotation.SingleClick;
import com.xuexiang.xui.utils.ViewUtils;
import com.xuexiang.xutil.common.StringUtils;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

/**
 * 操作符基础类
 */
public abstract class BaseOperatorFragment extends BaseFragment<FragmentTemplateBinding> {

    protected Disposable disposable;

    @NonNull
    @Override
    protected FragmentTemplateBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentTemplateBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {
        getBinding().tvInstruction.setText(getOperatorInstruction());
        getBinding().btnStart.setOnClickListener(this::handleOperationStart);
        getBinding().btnEnd.setOnClickListener(this::stopOperation);
        ViewUtils.setVisibility(getBinding().btnEnd, isContinuousOperation());
    }

    @SingleClick
    protected void handleOperationStart(View v) {
        beforeOperation();
        doOperation(v);
    }

    /**
     * 操作开始
     */
    protected void beforeOperation() {
        clearLog();
    }

    public void setDisposable(Disposable disposable) {
        this.disposable = disposable;
    }

    @NonNull
    protected <T> Disposable doSubscribe(Observable<T> observable) {
        return observable.subscribe(item -> printNormal(StringUtils.toString(item)), error -> printError(error.getMessage()),
                () -> printSuccess("Completed!"));
    }

    @NonNull
    protected <T> Disposable doSubscribe(Observable<T> observable, @NonNull Consumer<? super T> onNext) {
        return observable.subscribe(onNext, error -> printError(error.getMessage()),
                () -> printSuccess("Completed!"));
    }

    @NonNull
    protected <T> Disposable doSubscribe(Observable<T> observable, @NonNull Consumer<? super T> onNext, @NonNull Action onComplete) {
        return observable.subscribe(onNext, error -> printError(error.getMessage()), onComplete);
    }

    @NonNull
    protected <T> Disposable doSingleSubscribe(Single<T> single) {
        return single.subscribe(item -> printNormal(StringUtils.toString(item)), error -> printError(error.getMessage()));
    }

    @NonNull
    protected <T> Disposable doMaybeSubscribe(Maybe<T> maybe) {
        return maybe.subscribe(item -> printNormal(StringUtils.toString(item)), error -> printError(error.getMessage()),
                () -> printSuccess("Completed!"));
    }

    @NonNull
    protected Disposable doCompletableSubscribe(Completable completable) {
        return completable.subscribe(() -> printSuccess("Completed!"), error -> printError(error.getMessage()));
    }

    /**
     * 获取操作符的简介
     *
     * @return 操作符的简介
     */
    protected abstract String getOperatorInstruction();

    /**
     * 执行操作符操作
     */
    protected abstract void doOperation(View view);

    /**
     * 停止操作符操作
     */
    protected void stopOperation(View view) {

    }

    /**
     * 是否是连续的操作符
     */
    protected boolean isContinuousOperation() {
        return false;
    }

    protected boolean isOperationNotDisposed() {
        return disposable != null && !disposable.isDisposed();
    }

    @Override
    public void onDestroyView() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
        super.onDestroyView();
    }

    /**
     * 添加普通日志
     *
     * @param logContent 日志内容
     */
    public void printNormal(String logContent) {
        getBinding().logger.logNormal(logContent);
    }

    /**
     * 添加分割线
     */
    public void println() {
        getBinding().logger.logNormal("------------------------------------------------------------");
    }

    /**
     * 添加成功日志
     *
     * @param logContent 日志内容
     */
    public void printSuccess(String logContent) {
        getBinding().logger.logSuccess(logContent);
    }

    /**
     * 添加错误日志
     *
     * @param logContent 日志内容
     */
    public void printError(String logContent) {
        getBinding().logger.logError(logContent);
    }

    /**
     * 清除日志
     */
    public void clearLog() {
        getBinding().logger.clearLog();
    }

}
