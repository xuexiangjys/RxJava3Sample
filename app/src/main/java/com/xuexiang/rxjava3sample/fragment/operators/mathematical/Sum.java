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

package com.xuexiang.rxjava3sample.fragment.operators.mathematical;

import android.view.View;

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import hu.akarnokd.rxjava3.math.MathObservable;
import io.reactivex.rxjava3.core.Observable;

/**
 * 求序列数值总和操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Mathematical-and-Aggregate-Operators#sumdouble
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974516
 */
@Page(name = "sum\n计算Observable发射的数值的和并发射这个和")
public class Sum extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "sum操作符操作一个发射数值的Observable，仅发射单个值：原始Observable所有数值的和。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("求数组[4, 9, 8, 13, 43, 5]的总和：");

        printNormal("sumInt：");
        doSubscribe(MathObservable.sumInt(Observable.just(4, 9, 8, 13, 43, 5)));

        printNormal("sumFloat：");
        doSubscribe(MathObservable.sumFloat(Observable.just(4F, 9F, 8F, 13F, 43F, 5F)));

        printNormal("sumLong：");
        doSubscribe(MathObservable.sumLong(Observable.just(4L, 9L, 8L, 13L, 43L, 5L)));
    }
}
