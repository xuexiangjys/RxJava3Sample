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

package com.xuexiang.rxjava3sample.fragment.operators.utility;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 将Observable转换为另一个对象或数据结构
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974507
 */
@Page(name = "to\n将Observable转换为另一个对象或数据结构")
public class To extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "to操作符将Observable转换为另一个对象或数据结构。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("发射数组：[2, 5, 8, 3, 6]");
        Observable<Integer> original = Observable.just(2, 5, 8, 3, 6);

        printNormal("toList:");
        doSingleSubscribe(original.toList());

        printNormal("toSortedList:");
        doSingleSubscribe(original.toSortedList());

        printNormal("toMap:");
        // Map<K, T>
        doSingleSubscribe(original.toMap(x -> "key" + x));

        printNormal("toMultimap:");
        // Map<K, Collection<T>>
        doSingleSubscribe(original.toMultimap(x -> "key" + x % 3));
    }
}