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

package com.xuexiang.rxjava3sample.fragment.operators.conditional;

import android.view.View;

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 首发执行操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Conditional-and-Boolean-Operators#amb
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974509
 */
@Page(name = "amb\n多个Observable, 只让第一个发射数据的Observable发射全部数据")
public class Amb extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "给定多个Observable，只让第一个发射数据的Observable发射全部数据。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("先后发射数组:[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]");
        Observable<Integer> first = Observable.range(1, 5);
        Observable<Integer> second = Observable.range(6, 5);
        Observable<Integer> ambObservable = Observable.ambArray(first, second);
        doSubscribe(ambObservable);
    }
}
