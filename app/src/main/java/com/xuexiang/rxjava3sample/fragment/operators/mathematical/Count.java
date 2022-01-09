/*
 * Copyright (C) 2022 xuexiangjys(xuexiangjys@163.com)
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

package com.xuexiang.rxjava3sample.fragment.operators.mathematical;

import android.view.View;

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 求发射器发射数据项的数量
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Mathematical-and-Aggregate-Operators#count
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974516
 */
@Page(name = "count\n求发射器发射数据项的数量")
public class Count extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "count操作符将一个Observable转换成一个发射单个值的Observable，这个值表示原始Observable发射的数据的数量。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("发射数组[4, 9, 8, 13, 43, 5]");

        printNormal("count:");
        doSingleSubscribe(Observable.just(4, 9, 8, 13, 43, 5).count());
    }
}