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

package com.xuexiang.rxjava3sample.fragment.schedulers;

import android.view.View;

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.rxjava3sample.utils.ExecutorUtils;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 线程调度主要是靠subscribeOn和ObserveOn来完成的
 * <p>
 * subscribeOn改变调用它之前，直到observeOn调用代码的线程
 * observeOn改变调用它之后代码的线程
 * <p>还不懂的话，具体参见：
 * https://reactivex.io/documentation/scheduler.html
 */
@Page(name = "Scheduler调度\n通过subscribeOn和subscribeOn来完成")
public class SchedulerHandler extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "使用subscribeOn和subscribeOn操作符可以实现线程的调度。\n" +
                "* subscribeOn改变调用它之前，直到observeOn调用代码的线程。\n" +
                "* observeOn改变调用它之后代码的线程";
    }

    @Override
    protected void doOperation(View view) {
        Observable<String> observable = Observable.create((ObservableOnSubscribe<String>)
                emitter -> {
                    printNormalThreadInfo("subscribe");
                    emitter.onNext("this is data:");
                    emitter.onComplete();
                })
                // 第一个subscribeOn直到第一个observeOn都生效 My-Scheduler-1
                .subscribeOn(ExecutorUtils.getScheduler("My-Scheduler-1"))
                // 第二个subscribeOn不生效
                .subscribeOn(Schedulers.io())
                // observeOn生效 My-Scheduler-2
                .observeOn(ExecutorUtils.getScheduler("My-Scheduler-2"))
                .map(x -> {
                    printWarningThreadInfo("map-1");
                    return x + 1;
                })
                // 由于设置了observeOn，所以第三个subscribeOn不生效
                .subscribeOn(ExecutorUtils.getScheduler("My-Scheduler-3"))
                .map(x -> {
                    printWarningThreadInfo("map-2");
                    return x + 2;
                })
                // observeOn生效mainThread
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