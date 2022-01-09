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

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 抑制（过滤掉）连续重复的数据项
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Filtering-Observables#distinctUntilChanged
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974473
 */
@Page(name = "distinctUntilChanged\n过滤掉【连续】重复的数据项")
public class DistinctUntilChanged extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "distinctUntilChanged只是过滤掉连续重复的元素,不连续重复的是不过滤的。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("发射数组:[1, 1, 2, 1, 2, 3, 3, 4]");
        Observable<Integer> observable = Observable.just(1, 1, 2, 1, 2, 3, 3, 4)
                .distinctUntilChanged();
        doSubscribe(observable);
    }
}
