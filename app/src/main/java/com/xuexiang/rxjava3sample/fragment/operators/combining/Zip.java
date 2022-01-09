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
 * 压缩合并操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Combining-Observables#zip
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974491
 */
@Page(name = "zip\n使用一个函数将多个Observable组合发射出去")
public class Zip extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "zip操作符返回一个Observable，它使用这个函数按顺序结合两个或多个Observables发射的数据项，然后它发射这个函数返回的结果。它按照严格的顺序应用这个函数。它只发射与发射数据项最少的那个Observable一样多的数据。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("合并发射数组:[\"aaa\", \"bbb\", \"ccc\", \"ddd\"] 和 [\"111\", \"222\", \"333\"]");

        Observable<String> firstNames = Observable.just("aaa", "bbb", "ccc", "ddd");
        Observable<String> lastNames = Observable.just("111", "222", "333");

        Observable<String> zipResult = firstNames.zipWith(lastNames, (first, last) -> first + " " + last);
        doSubscribe(zipResult);
    }
}
