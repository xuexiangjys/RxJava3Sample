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
import com.xuexiang.rxjava3sample.fragment.operators.filtering.Debounce;
import com.xuexiang.rxjava3sample.fragment.operators.filtering.Distinct;
import com.xuexiang.rxjava3sample.fragment.operators.filtering.DistinctUntilChanged;
import com.xuexiang.rxjava3sample.fragment.operators.filtering.Filter;
import com.xuexiang.rxjava3sample.fragment.operators.filtering.First;
import com.xuexiang.rxjava3sample.fragment.operators.filtering.Last;
import com.xuexiang.rxjava3sample.fragment.operators.filtering.OfType;
import com.xuexiang.rxjava3sample.fragment.operators.filtering.Skip;
import com.xuexiang.rxjava3sample.fragment.operators.filtering.SkipLast;
import com.xuexiang.rxjava3sample.fragment.operators.filtering.Take;
import com.xuexiang.rxjava3sample.fragment.operators.filtering.TakeLast;
import com.xuexiang.rxjava3sample.fragment.operators.filtering.ThrottleFirst;
import com.xuexiang.rxjava3sample.fragment.operators.filtering.ThrottleWithTimeout;
import com.xuexiang.xpage.annotation.Page;

/**
 * 过滤类型的操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Filtering-Observables
 */
@Page(name = "Filtering\n过滤")
public class FilteringFragment extends BaseContainerFragment {

    @Override
    protected Class[] getPagesClasses() {
        return new Class[]{
                Filter.class,
                OfType.class,
                Debounce.class,
                ThrottleWithTimeout.class,
                ThrottleFirst.class,
                Distinct.class,
                DistinctUntilChanged.class,
                First.class,
                Last.class,
                Take.class,
                TakeLast.class,
                Skip.class,
                SkipLast.class
        };
    }
}
