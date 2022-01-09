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

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 跳过开始的N项数据
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Filtering-Observables#skip
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974480
 */
@Page(name = "skip\n跳过开始的N项数据, 和take相反")
public class Skip extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "skip操作符，忽略Observable发射的前N项数据，只保留之后的数据。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("发射数组:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
        Observable<Integer> observable = Observable.range(1, 10);

        printNormal("skip:");
        // 跳过前面四个
        doSubscribe(observable.skip(4));

        printNormal("skipWhile:");
        // 当输出数据x<5时都跳过
        doSubscribe(observable.skipWhile(x -> x < 5));
    }
}