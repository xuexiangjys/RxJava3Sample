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
 * 使用zip将前后有依赖的任务并行关联起来，合并输出
 *
 * 这里的并行任务，每个任务独立运行，统一输出（一般都是不同类输出）
 */
@Page(name = "Related Concurrent Task\n有关联的并行任务(zip)，n个输入1个输出")
public class RelatedConcurrentTaskFragment extends UseCaseTestFragment {

    @Override
    public void onClickTest() {
        super.onClickTest();
        // 并行任务，每个任务独立运行，统一输出
        Observable<String> observable = Observable.zip(task1(), task2(), task3(), task4(),
                (s, s2, s3, s4) -> "开始" + s + s2 + s3 + s4)
                .map(s -> s + "->完成");

        setDisposable(doSubscribe(observable, s -> printNormal("输出:" + s)));
    }

    private Observable<String> task1() {
        return doTask("", "任务1");
    }

    private Observable<String> task2() {
        return doTask("", "任务2");
    }

    private Observable<String> task3() {
        return doTask("", "任务3");
    }

    private Observable<String> task4() {
        return doTask("", "任务4");
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
