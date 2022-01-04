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

package com.xuexiang.rxjava3sample.fragment.operators.combining;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * 每次发射合并其他Observables最近一次数据
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Combining-Observables#combineLatest
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974486
 */
@Page(name = "combineLatest\n每次发射合并其他Observables最近一次数据")
public class CombineLatest extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "当两个Observables中的任何一个发射了数据时，使用一个函数结合每个Observable发射的最近数据项，并且基于这个函数的结果发射数据。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("A每600ms发射，B每350ms发射");

        Observable<Long> A = Observable.interval(600, TimeUnit.MILLISECONDS);
        Observable<Long> B = Observable.interval(350, TimeUnit.MILLISECONDS);

        Observable<String> result = Observable.combineLatest(A, B,
                (a, b) -> ("A:" + a + ", B:" + b));

        setDisposable(doSubscribe(result));
    }

    @Override
    protected boolean isContinuousOperation() {
        return true;
    }

    @Override
    protected void stopOperation(View view) {
        cancelSubscribe();
    }
}