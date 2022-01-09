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

package com.xuexiang.rxjava3sample.fragment.operators.conditional;

import android.view.View;

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;


/**
 * 条件判断，判断是否所有的数据项都满足某个条件
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Conditional-and-Boolean-Operators#all
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974509
 */
@Page(name = "all\n判断是否所有的数据项都满足某个条件")
public class All extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "传递一个谓词函数给all操作符，这个函数接受原始Observable发射的数据，根据计算返回一个布尔值。all返回一个只发射一个单个布尔值的Observable，如果原始Observable正常终止并且每一项数据都满足条件，就返回true；如果原始Observable的任何一项数据不满足条件就返回false。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("发射数组:[1, 2, 3, 4, 5], 要求每个数都小于6，发射结果：");
        Single<Boolean> observable = Observable.range(1, 5).all(x -> x < 6);
        doSingleSubscribe(observable);
    }
}
