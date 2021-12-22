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

import io.reactivex.rxjava3.core.Observable;

/**
 * 类型过滤操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Filtering-Observables#ofType
 */
@Page(name = "ofType\n类型过滤操作符，过滤出特定类型")
public class OfType extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "ofType可以过滤出特定类型的数据项并发出。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("发射数组:[1, 4.0, 3, 2.71, 2f, 7]");
        printNormal("取Integer类型:");
        Observable<Number> numbers = Observable.just(1, 4.0, 3, 2.71, 2F, 7);
        doSubscribe(numbers.ofType(Integer.class));
    }
}