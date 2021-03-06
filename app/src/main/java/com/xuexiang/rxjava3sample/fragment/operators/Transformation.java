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
import com.xuexiang.rxjava3sample.fragment.operators.transformation.Buffer;
import com.xuexiang.rxjava3sample.fragment.operators.transformation.Cast;
import com.xuexiang.rxjava3sample.fragment.operators.transformation.ConcatMap;
import com.xuexiang.rxjava3sample.fragment.operators.transformation.FlatMap;
import com.xuexiang.rxjava3sample.fragment.operators.transformation.GroupBy;
import com.xuexiang.rxjava3sample.fragment.operators.transformation.Map;
import com.xuexiang.rxjava3sample.fragment.operators.transformation.Scan;
import com.xuexiang.rxjava3sample.fragment.operators.transformation.SwitchMap;
import com.xuexiang.rxjava3sample.fragment.operators.transformation.Window;
import com.xuexiang.xpage.annotation.Page;

/**
 * 转换类型的操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Transforming-Observables
 */
@Page(name = "Transformation\n转换")
public class Transformation extends BaseContainerFragment {
    @Override
    protected Class[] getPagesClasses() {
        return new Class[]{
                Map.class,
                FlatMap.class,
                ConcatMap.class,
                SwitchMap.class,
                Scan.class,
                Cast.class,
                GroupBy.class,
                Buffer.class,
                Window.class
        };
    }
}
