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
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Schedulers共提供了如下5种线程调度器：
 * <p>
 * io：CachedThreadPool。这个调度器用于I/O操作，比如：读写文件，数据库，网络交互等等。行为模式和newThread()差不多，重点需要注意的是线程池是无限制的，大量的I/O调度操作将创建许多个线程并占用内存。
 * computation：FixedThreadPool。计算工作默认的调度器，这个计算指的是 CPU 密集型计算，即不会被 I/O 等操作限制性能的操作，例如图形的计算。这个 Scheduler 使用的固定的线程池，大小为 CPU 核数。
 * single：拥有一个线程单例，所有的任务都在这一个线程中执行，当此线程中有任务在执行的时候其他任务将按照队列先进先出的顺序依次执行。
 * newThread：为指定任务启动一个新的线程。
 * trampoline：在当前线程执行任务，如果当前线程有任务在执行，则会将其暂停下来，等插入进来的任务执行完成之后，再将未完成的任务接着执行。
 * <p>具体参见：
 * https://www.kancloud.cn/luponu/rxjava_zh/974451
 */
@Page(name = "Scheduler类型\n默认提供5种线程调度器")
public class SchedulerType extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "* io: 缓存线程池，线程数量无穷大，用于I/O操作。\n" +
                "* computation: 固定线程池，大小为CPU核数，用于CPU密集型计算（无阻塞）。\n" +
                "* single: 单线程池。\n" +
                "* newThread: 为指定任务启动一个新的线程。\n" +
                "* trampoline: 当其它排队的任务完成后，在当前线程排队开始执行。\n";
    }

    @Override
    protected void doOperation(View view) {
        Observable<Integer> observable = Observable.just(1)
                .subscribeOn(Schedulers.io())
                .map(x -> {
                    printWarningThreadInfo("map-1");
                    return x + 1;
                })
                .observeOn(Schedulers.computation())
                .map(x -> {
                    printWarningThreadInfo("map-2");
                    return x + 2;
                })
                .observeOn(Schedulers.newThread())
                .map(x -> {
                    printWarningThreadInfo("map-3");
                    return x + 3;
                })
                .observeOn(Schedulers.single())
                .map(x -> {
                    printWarningThreadInfo("map-4");
                    return x + 4;
                })
                .observeOn(Schedulers.trampoline())
                .map(x -> {
                    printWarningThreadInfo("map-5");
                    return x + 5;
                })
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