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

package com.xuexiang.rxjava3sample.fragment;

import com.xuexiang.rxjava3sample.core.BaseContainerFragment;
import com.xuexiang.rxjava3sample.fragment.operators.CombiningFragment;
import com.xuexiang.rxjava3sample.fragment.operators.ConditionalFragment;
import com.xuexiang.rxjava3sample.fragment.operators.CreationFragment;
import com.xuexiang.rxjava3sample.fragment.operators.ErrorHandlingFragment;
import com.xuexiang.rxjava3sample.fragment.operators.FilteringFragment;
import com.xuexiang.rxjava3sample.fragment.operators.MathematicalFragment;
import com.xuexiang.rxjava3sample.fragment.operators.ObservableUtilityFragment;
import com.xuexiang.rxjava3sample.fragment.operators.Transformation;
import com.xuexiang.xpage.annotation.Page;

/**
 * 操作符相关知识点
 *
 * @author xuexiang
 * @since 2022/1/9 1:32 上午
 */
@Page(name = "operators\n操作符")
public class OperatorsFragment extends BaseContainerFragment {

    @Override
    protected Class[] getPagesClasses() {
        return new Class[]{
                CreationFragment.class,
                Transformation.class,
                FilteringFragment.class,
                CombiningFragment.class,
                ErrorHandlingFragment.class,
                ObservableUtilityFragment.class,
                ConditionalFragment.class,
                MathematicalFragment.class
        };
    }
}
