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

package com.xuexiang.rxjava3sample.fragment.usecase.rxbinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.jakewharton.rxbinding4.widget.RxTextView;
import com.xuexiang.rxjava3sample.core.LoggerFragment;
import com.xuexiang.rxjava3sample.databinding.FragmentInputFilteringBinding;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xui.widget.textview.LoggerTextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;

/***
 * 使用debounce处理快速点击
 */
@Page(name = "Input Filtering\n输入过滤(debounce)")
public class InputFilteringFragment extends LoggerFragment<FragmentInputFilteringBinding> {
    @NonNull
    @Override
    protected FragmentInputFilteringBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentInputFilteringBinding.inflate(inflater, container, false);
    }

    @NonNull
    @Override
    protected LoggerTextView getLogger() {
        return getBinding().logger;
    }

    @Override
    protected void initViews() {
        Observable<CharSequence> observable = RxTextView.textChanges(getBinding().etInput)
                .debounce(1, TimeUnit.SECONDS)
                .skip(1) //跳过第1次数据发射 = 初始输入框的空字符状态
                .observeOn(AndroidSchedulers.mainThread());

        doSubscribe(observable, input -> printSuccess("输入内容:" + input));
    }
}
