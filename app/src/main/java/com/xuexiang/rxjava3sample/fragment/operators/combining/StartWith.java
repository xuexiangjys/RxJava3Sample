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

import io.reactivex.rxjava3.core.Observable;

/**
 * 首项插入合并操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Combining-Observables#startWith
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974489
 */
@Page(name = "startWith\n在数据序列的开头插入一条指定的项")
public class StartWith extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "如果你想要一个Observable在发射数据之前先发射一个指定的数据序列，可以使用startWith操作符。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("向数组[\"aaa\", \"bbb\"]中插入\"ccc\"");

        Observable<String> names = Observable.just("aaa", "bbb");
        doSubscribe(names.startWith(Observable.just("ccc")));
    }
}