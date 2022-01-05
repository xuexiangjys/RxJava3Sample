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
import com.xuexiang.rxjava3sample.fragment.operators.mathematical.Average;
import com.xuexiang.rxjava3sample.fragment.operators.mathematical.Count;
import com.xuexiang.rxjava3sample.fragment.operators.mathematical.Max;
import com.xuexiang.rxjava3sample.fragment.operators.mathematical.Min;
import com.xuexiang.rxjava3sample.fragment.operators.mathematical.Reduce;
import com.xuexiang.rxjava3sample.fragment.operators.mathematical.Sum;
import com.xuexiang.xpage.annotation.Page;

/**
 * 算术和聚合操作
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Mathematical-and-Aggregate-Operators
 */
@Page(name = "Mathematical and Aggregate\n算术和聚合, 需要引用rxjava3-extensions")
public class MathematicalFragment extends BaseContainerFragment {
    @Override
    protected Class[] getPagesClasses() {
        return new Class[]{
                Reduce.class,
                Max.class,
                Min.class,
                Average.class,
                Sum.class,
                Count.class
        };
    }
}
