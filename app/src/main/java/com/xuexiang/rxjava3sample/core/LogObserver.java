/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
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
 */

package com.xuexiang.rxjava3sample.core;

import androidx.annotation.NonNull;

import com.xuexiang.xutil.common.StringUtils;

import io.reactivex.rxjava3.observers.DisposableObserver;

/**
 * 日志订阅者
 *
 * @author xuexiang
 * @since 2022/1/9 2:53 下午
 */
public class LogObserver<T> extends DisposableObserver<T> {

    private static final String DEFAULT_TAG = "LogObserver";

    private final ILogPrinter mLogPrinter;

    private final String mTagPrefix;

    public LogObserver(@NonNull ILogPrinter logPrinter) {
       this(logPrinter, DEFAULT_TAG);
    }

    public LogObserver(@NonNull ILogPrinter logPrinter, @NonNull String tag) {
        mLogPrinter = logPrinter;
        mTagPrefix = String.format("[%s] ", tag);
    }

    @Override
    protected void onStart() {
        mLogPrinter.printWarning(mTagPrefix + "Subscriber is onStart...");
    }

    @Override
    public void onComplete() {
        mLogPrinter.printSuccess(mTagPrefix + "onComplete!");
    }

    @Override
    public void onNext(@NonNull T t) {
        mLogPrinter.printNormal(mTagPrefix + "onNext:" + StringUtils.toString(t));
    }

    @Override
    public final void onError(@NonNull Throwable e) {
        mLogPrinter.printError(mTagPrefix + "onError:" + e.getMessage());
    }

    public String getTagPrefix() {
        return mTagPrefix;
    }
}
