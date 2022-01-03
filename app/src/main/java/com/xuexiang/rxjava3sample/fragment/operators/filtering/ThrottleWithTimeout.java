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

package com.xuexiang.rxjava3sample.fragment.operators.filtering;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 过滤高频输出
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Filtering-Observables#throttleWithTimeout
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974472
 */
@Page(name = "throttleWithTimeout\n同debounce功能一样，是debounce的别名")
public class ThrottleWithTimeout extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "throttleWithTimeout操作符会过滤掉发射速率过快的数据项。";
    }

    @Override
    protected void doOperation(View view) {
        // Diagram:
        // -A--------------B----C-D-------------------E-|---->
        //  a---------1s
        //                 b---------1s
        //                      c---------1s
        //                        d---------1s
        //                                            e-|---->
        // -----------A---------------------D-----------E-|-->

        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("A"); // A和B间隔1500ms，大于指定1000ms，所以输出
            Thread.sleep(1500);

            emitter.onNext("B"); // B和C间隔500ms，小于指定1000ms，所以不输出
            Thread.sleep(500);

            emitter.onNext("C"); // C和D间隔250ms，小于指定1000ms，所以不输出
            Thread.sleep(250);

            emitter.onNext("D"); // D和E间隔2000ms，大于指定1000ms，所以输出
            Thread.sleep(2000);

            emitter.onNext("E"); // E作为最后一个输出，没有间隔，所以一定会输出
            emitter.onComplete();
        });

        // 输出A、D、E
        doSubscribe(source.subscribeOn(Schedulers.io())
                .throttleWithTimeout(1000, TimeUnit.MILLISECONDS));
    }
}