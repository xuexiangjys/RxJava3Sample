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
 * 过滤条件操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Filtering-Observables#filter
 */
@Page(name = "filter\n过滤条件操作符")
public class Filter extends BaseOperatorFragment {


    @Override
    protected String getOperatorInstruction() {
        return "Filter操作符使用你指定的一个谓词函数测试数据项，只有通过测试的数据才会被发射。";
    }

    @Override
    protected void doOperation(View view) {
        // 取1～10中的偶数输出
        Observable<Integer> observable = Observable.range(1, 10)
                .filter(x -> x % 2 == 0);
        doSubscribe(observable);
    }
}