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

package com.xuexiang.rxjava3sample.fragment.usecase;

import com.xuexiang.rxjava3sample.core.BaseContainerFragment;
import com.xuexiang.rxjava3sample.fragment.usecase.rxbinding.InputFilteringFragment;
import com.xuexiang.rxjava3sample.fragment.usecase.rxbinding.LinkageRefreshFragment;
import com.xuexiang.rxjava3sample.fragment.usecase.rxbinding.QuickClickFragment;
import com.xuexiang.xpage.annotation.Page;

/**
 * RxBinding使用案例
 *
 * @author xuexiang
 * @since 2022/1/9 1:31 上午
 */
@Page(name = "RxBinding\nUI相关使用案例")
public class RxBindingFragment extends BaseContainerFragment {

    @Override
    protected Class[] getPagesClasses() {
        return new Class[]{
                QuickClickFragment.class,
                InputFilteringFragment.class,
                LinkageRefreshFragment.class
        };
    }
}
