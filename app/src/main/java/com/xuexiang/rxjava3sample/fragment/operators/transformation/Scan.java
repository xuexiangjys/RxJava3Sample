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

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 连续变换操作
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Transforming-Observables#scan
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974469
 */
@Page(name = "scan\n连续变换操作")
public class Scan extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "连续地对数据序列的每一项应用一个函数，然后连续发射结果";
    }

    @Override
    protected void doOperation(View view) {
        int initialValue = 10;
        printNormal("initialValue:" + initialValue);
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5)
                .scan(initialValue, (partialSum, x) -> {
                    printNormal("process " + partialSum + "+" + x);
                    return partialSum + x;
                });
        doSubscribe(observable);
    }
}
