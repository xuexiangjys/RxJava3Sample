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
import com.xuexiang.rxjava3sample.fragment.operators.creation.Create;
import com.xuexiang.rxjava3sample.fragment.operators.creation.Empty;
import com.xuexiang.rxjava3sample.fragment.operators.creation.Error;
import com.xuexiang.rxjava3sample.fragment.operators.creation.From;
import com.xuexiang.rxjava3sample.fragment.operators.creation.Interval;
import com.xuexiang.rxjava3sample.fragment.operators.creation.Just;
import com.xuexiang.rxjava3sample.fragment.operators.creation.Timer;
import com.xuexiang.xpage.annotation.Page;

/**
 * 创建类型的操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Creating-Observables
 */
@Page(name = "Creation(创建)")
public class CreationFragment extends BaseContainerFragment {

    @Override
    protected Class[] getPagesClasses() {
        return new Class[]{
                Create.class,
                Just.class,
                Timer.class,
                Interval.class,
                From.class,
                Error.class,
                Empty.class
        };
    }
}
