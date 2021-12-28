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

package com.xuexiang.rxjava3sample.fragment.operators.transformation;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 类型转换操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Transforming-Observables#cast
 */
@Page(name = "cast\n类型转换操作符")
public class Cast extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "cast将发射出去的数据转换成指定类型, 如果类型无法转换将会报错终止。";
    }

    @Override
    protected void doOperation(View view) {
        Observable<Object> numbers = Observable.just(1, 4.0, 3F, 7, 12, 4.6, 5);
        // 强转Integer类型
        doSubscribe(numbers.cast(Integer.class));
        // 强转Number类型
        doSubscribe(numbers.cast(Number.class));
    }
}
