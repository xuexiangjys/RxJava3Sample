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

package com.xuexiang.rxjava3sample.fragment.usecase.rxjava;

import com.xuexiang.rxjava3sample.core.UseCaseTestFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/***
 * 使用flatMap将前后依赖的任务串行关联起来
 *
 * 这里的串行任务，前一个任务的输出是后一个任务的输入
 */
@Page(name = "Serial Task\n串行任务(flatMap)，1个输入1个输出")
public class SerialTaskFragment extends UseCaseTestFragment {

    @Override
    public void onClickTest() {
        super.onClickTest();
        // 串行任务，前一个任务的输出是后一个任务的输入
        Observable<String> observable = task1("开始")
                .flatMap(this::task2)
                .flatMap(this::task3)
                .flatMap(this::task4)
                .map(s -> s + "->完成");

        setDisposable(doSubscribe(observable, s -> printNormal("输出:" + s)));
    }

    private Observable<String> task1(String input) {
        return doTask(input, "任务1");
    }

    private Observable<String> task2(String input) {
        return doTask(input, "任务2");
    }

    private Observable<String> task3(String input) {
        return doTask(input, "任务3");
    }

    private Observable<String> task4(String input) {
        return doTask(input, "任务4");
    }

    private Observable<String> doTask(String input, String taskName) {
        return Observable.just(input)
                .map(s -> {
                    printNormal("开始执行" + taskName);
                    return s + "->" + taskName;
                })
                .delay(1, TimeUnit.SECONDS);
    }

}
