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
import com.xuexiang.rxjava3sample.fragment.operators.conditional.All;
import com.xuexiang.rxjava3sample.fragment.operators.conditional.Amb;
import com.xuexiang.rxjava3sample.fragment.operators.conditional.Contains;
import com.xuexiang.rxjava3sample.fragment.operators.conditional.SkipUntil;
import com.xuexiang.rxjava3sample.fragment.operators.conditional.TakeUntil;
import com.xuexiang.xpage.annotation.Page;

/**
 * 条件和布尔操作
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Conditional-and-Boolean-Operators
 */
@Page(name = "Conditional & Boolean\n条件和布尔操作")
public class ConditionalFragment extends BaseContainerFragment {
    @Override
    protected Class[] getPagesClasses() {
        return new Class[]{
                Amb.class,
                All.class,
                Contains.class,
                TakeUntil.class,
                SkipUntil.class
        };
    }
}
