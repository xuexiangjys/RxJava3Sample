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
 * 变换操作
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Transforming-Observables#map
 * <p>
 * Map发出的是值
 */
@Page(name = "map\n变换操作，适用于一对一转换")
public class Map extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "对Observable发射的每一项数据应用一个函数，执行变换操作";
    }

    @Override
    protected void doOperation(View view) {
        Observable<String> observable = Observable.just(1, 2, 3)
                .map(x -> {
                    printNormal("map:" + x);
                    return "项目" + x;
                });
        doSubscribe(observable);
    }
}
