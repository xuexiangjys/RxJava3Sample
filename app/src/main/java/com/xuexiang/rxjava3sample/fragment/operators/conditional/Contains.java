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

package com.xuexiang.rxjava3sample.fragment.operators.conditional;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * 条件判断，判定一个Observable是否发射一个特定的值
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Conditional-and-Boolean-Operators#contains
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974509
 */
@Page(name = "contains\n判定一个Observable是否发射一个特定的值")
public class Contains extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "给contains传一个指定的值，如果原始Observable发射了那个值，它返回的Observable将发射true，否则发射false。\n" +
                "相关的一个操作符isEmpty用于判定原始Observable是否没有发射任何数据。";
    }

    @Override
    protected void doOperation(View view) {
        Observable<Integer> observable = Observable.range(1, 5);

        printNormal("发射数组:[1, 2, 3, 4, 5], 判断是否包含数字5，发射结果：");
        Single<Boolean> observable1 = observable.contains(5);
        doSingleSubscribe(observable1);

        printNormal("发射数组:[1, 2, 3, 4, 5], 判断是否为空，发射结果：");
        Single<Boolean> observable2 = observable.isEmpty();
        doSingleSubscribe(observable2);
    }
}
