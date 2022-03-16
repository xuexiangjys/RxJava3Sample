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
import com.xuexiang.rxjava3sample.fragment.operators.combining.CombineLatest;
import com.xuexiang.rxjava3sample.fragment.operators.combining.Concat;
import com.xuexiang.rxjava3sample.fragment.operators.combining.Merge;
import com.xuexiang.rxjava3sample.fragment.operators.combining.StartWith;
import com.xuexiang.rxjava3sample.fragment.operators.combining.Zip;
import com.xuexiang.xpage.annotation.Page;

/**
 * 结合类型的操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Combining-Observables
 */
@Page(name = "Combining\n结合")
public class CombiningFragment extends BaseContainerFragment {
    @Override
    protected Class[] getPagesClasses() {
        return new Class[]{
                Merge.class,
                Concat.class,
                Zip.class,
                CombineLatest.class,
                StartWith.class
        };
    }
}
