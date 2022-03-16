/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
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
 */

package com.xuexiang.rxjava3sample.fragment.usecase.rxbus.utils;

import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.xuexiang.rxjava3sample.core.BaseFragment;
import com.xuexiang.rxjava3sample.databinding.FragmentRxbusTestBinding;
import com.xuexiang.rxjava3sample.fragment.usecase.rxbus.utils.entity.EventKey;
import com.xuexiang.rxjava3sample.utils.rxbus.RxBusUtils;
import com.xuexiang.rxjava3sample.utils.rxbus.SubscribeInfo;
import com.xuexiang.xui.widget.actionbar.TitleBar;

/**
 * 基础rxbus
 *
 * @author xuexiang
 * @since 2022/3/17 1:35 上午
 */
public abstract class BaseRxBusTestFragment extends BaseFragment<FragmentRxbusTestBinding> {

    protected SubscribeInfo<String> mSubscribeInfo;

    @Override
    protected TitleBar initTitle() {
        return null;
    }

    @NonNull
    @Override
    protected FragmentRxbusTestBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentRxbusTestBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {
        mSubscribeInfo = RxBusUtils.get().onMainThread(EventKey.EVENT_CLEAR, String.class, eventName -> showContent(""));
        getBinding().btCancel.setOnClickListener(v -> onCancelEvent());
        getBinding().btClear.setOnClickListener(v -> showContent(""));
    }

    public void setTitle(String title) {
        getBinding().tvTitle.setText(title);
    }

    /**
     * 显示内容
     *
     * @param msg 内容
     */
    public void showContent(String eventName, final String msg) {
        showContent("事件Key:" + eventName + "\n" + msg);
    }

    /**
     * 显示内容
     *
     * @param msg 内容
     */
    public void showContent(final String msg) {
        if (isMainLooper()) {
            getBinding().tvContent.setText(msg);
        } else {
            runOnUiThread(() -> getBinding().tvContent.setText(msg));
        }
    }

    public boolean isMainLooper() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    protected abstract void onCancelEvent();

    @Override
    public void onDestroy() {
        onCancelEvent();
        super.onDestroy();
    }

    protected void runOnUiThread(Runnable action) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(action);
        }
    }

    /**
     * 设置背景颜色
     *
     * @param color 背景颜色
     */
    protected void setBackgroundColor(int color) {
        mRootView.setBackgroundColor(getResources().getColor(color));
    }
}
