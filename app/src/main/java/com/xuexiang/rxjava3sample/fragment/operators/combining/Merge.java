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

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 合并操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Combining-Observables#merge
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974488
 */
@Page(name = "merge\n将多个Observable合并为一个(允许交错)")
public class Merge extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "merge操作符将多个Observables的输出合并，就好像它们是一个单个的Observable一样。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("合并发射数组:[4, 5, 6] 和 [1, 2, 3]");
        Observable<Integer> observable = Observable.just(4, 5, 6)
                .mergeWith(Observable.just(1, 2, 3));
        doSubscribe(observable);

        printNormal("两个发射组有一个发射了error");
        Observable<String> errorObservable = Observable.error(new IllegalArgumentException("This is an error！！"));
        Observable<String> normalObservable = Observable.just("Four", "Five", "Six");
        doSubscribe(Observable.mergeDelayError(errorObservable, normalObservable));
    }
}
