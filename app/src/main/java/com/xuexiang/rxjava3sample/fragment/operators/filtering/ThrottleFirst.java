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

package com.xuexiang.rxjava3sample.fragment.operators.filtering;

import android.view.View;

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.rxjava3sample.fragment.usecase.rxbinding.QuickClickFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 过滤高频输出
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Filtering-Observables#throttleFirst
 */
@Page(name = "throttleFirst\n一段时间内只发射一次，常用于快速点击等场景")
public class ThrottleFirst extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "throttleFirst操作符一段时间内只发射一次。";
    }

    @Override
    protected Class getUseCase() {
        return QuickClickFragment.class;
    }

    @Override
    protected void doOperation(View view) {
        // Diagram:
        // -A----B-C-------D-----E-|-->
        //  a---------1s
        //                 d-------|-->
        // -A--------------D-------|-->
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("A"); // A作为第一个，直接输出

            Thread.sleep(500);
            emitter.onNext("B"); // B与A间隔500ms，小于指定1000ms，所以不输出

            Thread.sleep(200); // C与A间隔700ms，小于指定1000ms，所以不输出
            emitter.onNext("C");

            Thread.sleep(800); // D与A间隔1500ms，大于指定1000ms，所以输出
            emitter.onNext("D");

            Thread.sleep(600); // E与D间隔600ms，小于指定1000ms，所以不输出
            emitter.onNext("E");
            emitter.onComplete();
        });

        // 输出A、D
        setDisposable(doSubscribe(source.subscribeOn(Schedulers.io())
                .throttleFirst(1000, TimeUnit.MILLISECONDS)));
    }
}