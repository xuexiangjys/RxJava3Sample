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

package com.xuexiang.rxjava3sample.fragment.plugins;

import android.view.View;

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.rxjava3sample.utils.ExecutorUtils;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;


/**
 * 使用RxJavaPlugins可以使用你选择的调度器覆盖默认的计算、IO和新线程调度 (Scheduler).
 */
@Page(name = "HookScheduler\n可以使用你选择的调度器覆盖默认的计算、IO和新线程调度 (Scheduler)")
public class HookScheduler extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "使用RxJavaPlugins可以使用你选择的调度器覆盖默认的计算、IO和新线程调度 (Scheduler)。";
    }

    @Override
    protected void doOperation(View view) {
        // Hook IoScheduler
        RxJavaPlugins.setIoSchedulerHandler(schedulerSupplier -> {
            printError("Hook IoScheduler!");
            return ExecutorUtils.getIoScheduler("Custom-");
        });

        doSubscribe(Observable.just("1234")
                .map(x -> {
                    String log = "thread name:" + Thread.currentThread().getName();
                    printWarning(log);
                    return Integer.parseInt(x);
                })
                .subscribeOn(Schedulers.io()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        RxJavaPlugins.reset();
    }
}