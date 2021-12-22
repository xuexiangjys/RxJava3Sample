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

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * 只发射第一项（或者满足某个条件的第一项）数据。
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Filtering-Observables#first
 */
@Page(name = "first\n只取第一项数据进行发射")
public class First extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "first操作符只发射第一项（或者满足某个条件的第一项）数据。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("发射数组:[A, B, C]");
        Observable<String> source = Observable.just("A", "B", "C");

        printNormal("first:");
        Single<String> firstOrDefault = source.first("D");
        doSingleSubscribe(firstOrDefault);

        printNormal("firstElement:");
        Maybe<String> firstElement = source.firstElement();
        doMaybeSubscribe(firstElement);

        println();

        printNormal("发射数组:[]");
        Observable<String> source2 = Observable.empty();

        printNormal("first:");
        Single<String> firstOrDefault2 = source2.first("D");
        doSingleSubscribe(firstOrDefault2);

        printNormal("firstElement:");
        Maybe<String> firstElement2 = source2.firstElement();
        doMaybeSubscribe(firstElement2);

    }
}