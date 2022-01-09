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
 * 求序列平均值操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Mathematical-and-Aggregate-Operators#averagedouble
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974515
 */
@Page(name = "average\n计算发射数字的平均值并发射结果")
public class Average extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "average操作符操作符一个发射数字的Observable，并发射单个值：原始Observable发射的数字序列的平均值。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("求数组[4, 9, 8, 13, 43, 5]的平均值：");
        Observable<Integer> numbers = Observable.just(4, 9, 8, 13, 43, 5);

        printNormal("averageFloat：");
        doSubscribe(MathObservable.averageFloat(numbers));

        printNormal("averageDouble：");
        doSubscribe(MathObservable.averageDouble(numbers));
    }
}