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

package com.xuexiang.rxjava3sample.fragment.operators.combining;

import android.view.View;

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * 连接合并操作符
 */
@Page(name = "Concat\n将多个Observable连接合并为一个(不允许交错)")
public class Concat extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "严格按顺序将多个发射器合并成一个发射器, 依次发送。发送完一个再接着发送第二个。";
    }

    @Override
    protected void doOperation(View view) {
        // flatMap 是无序的，但是concat是有序的，严格按照顺序执行
        Observable<Integer> observable1 = Observable.just(5, 4, 3, 2, 1)
                .flatMap(x -> Observable.just(x).delay(x, TimeUnit.SECONDS));
        Observable<Integer> observable2 = Observable.just(1, 3, 2, 5, 4)
                .concatMap(x -> Observable.just(x).map(y -> y * 100).delay(x * 100, TimeUnit.MILLISECONDS));
        doSubscribe(Observable.concat(observable1, observable2));
    }
}
