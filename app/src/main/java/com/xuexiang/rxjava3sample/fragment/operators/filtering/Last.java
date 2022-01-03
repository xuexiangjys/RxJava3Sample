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
 * 只发射最后一项（或者满足某个条件的最后一项）数据。
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Filtering-Observables#last
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974478
 */
@Page(name = "last\n只取最后一项数据进行发射")
public class Last extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "last操作符只发射最后一项（或者满足某个条件的最后一项）数据。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("发射数组:[A, B, C]");
        Observable<String> source = Observable.just("A", "B", "C");

        printNormal("last:");
        Single<String> lastOrDefault = source.last("D");
        doSingleSubscribe(lastOrDefault);

        printNormal("lastElement:");
        Maybe<String> lastElement = source.lastElement();
        doMaybeSubscribe(lastElement);

        println();

        printNormal("发射数组:[]");
        Observable<String> source2 = Observable.empty();

        printNormal("last:");
        Single<String> lastOrDefault2 = source2.last("D");
        doSingleSubscribe(lastOrDefault2);

        printNormal("lastElement:");
        Maybe<String> lastElement2 = source2.lastElement();
        doMaybeSubscribe(lastElement2);

    }
}