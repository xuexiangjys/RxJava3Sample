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

package com.xuexiang.rxjava3sample.fragment.operators.utility;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.rxjava3sample.utils.ExecutorUtils;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 指定Observable自身在哪个调度器上执行
 * <p>
 * https://reactivex.io/documentation/operators/subscribeon.html
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974502
 */
@Page(name = "subscribeOn\n指定Observable自身在哪个调度器上执行")
public class SubscribeOn extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "你可以使用subscribeOn操作符指定Observable在一个特定的调度器上运转。\n" +
                "subscribeOn()改变调用它之前代码的线程。\n" +
                "observeOn()改变调用它之后代码的线程";
    }

    @Override
    protected void doOperation(View view) {
        Observable<String> observable = Observable.create((ObservableOnSubscribe<String>)
                emitter -> {
                    printNormalThreadInfo("subscribe");
                    emitter.onNext("this is data:");
                    emitter.onComplete();
                })
                .subscribeOn(ExecutorUtils.getScheduler("My-Scheduler-1"))
                .subscribeOn(Schedulers.io())
                .map(x -> {
                    printWarningThreadInfo("map-1");
                    return x + 1;
                })
                .subscribeOn(ExecutorUtils.getScheduler("My-Scheduler-2"))
                .map(x -> {
                    printWarningThreadInfo("map-2");
                    return x + 2;
                })
                .subscribeOn(ExecutorUtils.getScheduler("My-Scheduler-3"))
                .doOnEach(notification -> printNormalThreadInfo(notification.toString()))
                .observeOn(AndroidSchedulers.mainThread());

        doSubscribe(observable, integer -> printNormalThreadInfo("onNext:" + integer));
    }

    private void printWarningThreadInfo(String action) {
        printWarning(action + ", ThreadInfo:" + Thread.currentThread().getName());
    }

    private void printNormalThreadInfo(String action) {
        printNormal(action + ", ThreadInfo:" + Thread.currentThread().getName());
    }
}