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

package com.xuexiang.rxjava3sample.fragment.operators;

import com.xuexiang.rxjava3sample.core.BaseContainerFragment;
import com.xuexiang.rxjava3sample.fragment.operators.utility.Delay;
import com.xuexiang.rxjava3sample.fragment.operators.utility.Do;
import com.xuexiang.rxjava3sample.fragment.operators.utility.SubscribeOn;
import com.xuexiang.rxjava3sample.fragment.operators.utility.TimeInterval;
import com.xuexiang.rxjava3sample.fragment.operators.utility.Timeout;
import com.xuexiang.rxjava3sample.fragment.operators.utility.Timestamp;
import com.xuexiang.rxjava3sample.fragment.operators.utility.To;
import com.xuexiang.xpage.annotation.Page;

/**
 * 错误处理类型的操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Observable-Utility-Operators
 */
@Page(name = "Observable Utility\n辅助操作")
public class ObservableUtilityFragment extends BaseContainerFragment {

    @Override
    protected Class[] getPagesClasses() {
        return new Class[]{
                SubscribeOn.class,
                Delay.class,
                Do.class,
                To.class,
                Timeout.class,
                Timestamp.class,
                TimeInterval.class
        };
    }
}
