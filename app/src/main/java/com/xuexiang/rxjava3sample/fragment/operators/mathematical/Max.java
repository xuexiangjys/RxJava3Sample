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

package com.xuexiang.rxjava3sample.fragment.operators.mathematical;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import hu.akarnokd.rxjava3.math.MathObservable;
import io.reactivex.rxjava3.core.Observable;


/**
 * 求序列最大值操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Mathematical-and-Aggregate-Operators#max
 */
@Page(name = "max\n求序列最大值并发射")
public class Max extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "max操作符可以计算出序列中的最大值并进行发射。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("求数组[4, 9, 8, 13, 43, 5]中的最大值：");
        Observable<Integer> numbers = Observable.just(4, 9, 8, 13, 43, 5);

        doSubscribe(MathObservable.max(numbers));

        printNormal("求字符串数组[\"Kirk\", \"Spock\", \"Chekov\", \"Sulu\"]中的最大值：");
        Observable<String> strings = Observable.just("Kirk", "Spock", "Chekov", "Sulu");

        doSubscribe(MathObservable.max(strings));
    }
}