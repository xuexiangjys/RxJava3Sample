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
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observables.GroupedObservable;

/**
 * 分组操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Transforming-Observables#groupBy
 */
@Page(name = "groupBy\n分组操作符")
public class GroupBy extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "将一个Observable按某个规则进行分组。分拆为一些Observables集合，它们中的每一个发射原始Observable的一个子集";
    }

    @Override
    protected void doOperation(View view) {
        // String为组类型，Integer为值类型
        Observable<GroupedObservable<String, Integer>> groupedObservable = Observable.range(0, 10)
                .groupBy(x -> "[" + (x % 3) + "]");

        doSubscribe(groupedObservable,
                group ->
                        doSubscribe(group,
                                value -> printNormal("group key:" + group.getKey() + ", value:" + value)),
                () -> printSuccess("Group Completed!"));
    }
}
