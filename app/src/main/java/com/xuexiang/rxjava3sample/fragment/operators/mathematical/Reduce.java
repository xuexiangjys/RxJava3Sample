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

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 累积操作符，按顺序对Observable发射的每项数据应用一个函数并发射最终的值
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Mathematical-and-Aggregate-Operators#reduce
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974516
 */
@Page(name = "reduce\n累积操作符，按顺序对Observable发射的每项数据应用一个函数并发射最终的值")
public class Reduce extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "reduce操作符对原始Observable发射数据的第一项应用一个函数，然后再将这个函数的返回值与第二项数据一起传递给函数，以此类推，持续这个过程知道原始Observable发射它的最后一项数据并终止，此时Reduce返回的Observable发射这个函数返回的最终值。";
    }

    @Override
    protected void doOperation(View view) {
        doMaybeSubscribe(Observable.range(1, 5)
                .reduce((product, x) -> {
                    printNormal("process " + product + " * " + x);
                    return product * x;
                }));
    }
}