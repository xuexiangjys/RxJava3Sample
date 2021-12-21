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
 * 前N项取值操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Filtering-Observables#take
 */
@Page(name = "take\n只发射前面的N项数据")
public class Take extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "Take操作符让你可以修改Observable的行为，只返回前面的N项数据，然后发射完成通知，忽略剩余的数据。";
    }

    @Override
    protected void doOperation(View view) {
        Observable<Integer> observable = Observable.range(1, 10)
                // 只取前面四个
                .take(4);
        doSubscribe(observable);
    }
}