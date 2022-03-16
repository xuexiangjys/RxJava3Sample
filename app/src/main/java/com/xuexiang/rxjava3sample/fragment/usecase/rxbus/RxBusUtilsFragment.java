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

package com.xuexiang.rxjava3sample.fragment.usecase.rxbus;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.xuexiang.rxjava3sample.core.BaseFragment;
import com.xuexiang.rxjava3sample.databinding.FragmentRxbusUtilsBinding;
import com.xuexiang.xpage.annotation.Page;

@Page(name = "RxBusUtils\n工具类使用")
public class RxBusUtilsFragment extends BaseFragment<FragmentRxbusUtilsBinding> {

    @NonNull
    @Override
    protected FragmentRxbusUtilsBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentRxbusUtilsBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {

    }
}
