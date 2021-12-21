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

package com.xuexiang.rxjava3sample.fragment.operators.creation;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 整数序列发射器
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Creating-Observables#range
 */
@Page(name = "range\n整数序列发射器")
public class Range extends BaseOperatorFragment {
    @Override
    protected String getOperatorInstruction() {
        return "创建一个发射特定整数序列的Observable";
    }

    @Override
    protected void doOperation(View view) {
        Observable<Integer> observable = Observable.range(1, 10);
        doSubscribe(observable);
    }
}
