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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.xuexiang.rxjava3sample.R;
import com.xuexiang.rxjava3sample.core.BaseFragment;
import com.xuexiang.rxjava3sample.databinding.FragmentRxbusControlBinding;
import com.xuexiang.rxjava3sample.fragment.usecase.rxbus.utils.entity.Event;
import com.xuexiang.rxjava3sample.fragment.usecase.rxbus.utils.entity.EventKey;
import com.xuexiang.rxjava3sample.utils.rxbus.RxBusUtils;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xutil.system.AppExecutors;

/**
 * RxBus演示示例
 *
 * @author xuexiang
 * @since 2022/3/17 1:58 上午
 */
public class RxBusControlFragment extends BaseFragment<FragmentRxbusControlBinding> implements View.OnClickListener {

    @NonNull
    @Override
    protected FragmentRxbusControlBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentRxbusControlBinding.inflate(inflater, container, false);
    }

    @Override
    protected TitleBar initTitle() {
        return null;
    }

    @Override
    protected void initViews() {
        getBinding().btnSendData.setOnClickListener(this);
        getBinding().btnSendNodata.setOnClickListener(this);
        getBinding().btnBackMainthread.setOnClickListener(this);
        getBinding().btnBackNormal.setOnClickListener(this);
        getBinding().btnOneByOne.setOnClickListener(this);
        getBinding().btnOneByMore.setOnClickListener(this);
        getBinding().btnClearAll.setOnClickListener(this);
    }


    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_send_data) {
            RxBusUtils.get().post(EventKey.EVENT_HAVE_DATA, new Event(EventKey.EVENT_HAVE_DATA, "这里携带的是数据"));
        } else if (id == R.id.btn_send_nodata) {
            RxBusUtils.get().postRxEvent(EventKey.EVENT_NO_DATA);
        } else if (id == R.id.btn_back_mainthread) {
            AppExecutors.get().poolIO().execute(() -> RxBusUtils.get().post(EventKey.EVENT_BACK_MAINTHREAD));
        } else if (id == R.id.btn_back_normal) {
            AppExecutors.get().poolIO().execute(() -> RxBusUtils.get().post(EventKey.EVENT_BACK_NORMAL));
        } else if (id == R.id.btn_one_by_one) {
            RxBusUtils.get().post(EventKey.EVENT_ONE_BY_ONE);
        } else if (id == R.id.btn_one_by_more) {
            RxBusUtils.get().post(EventKey.EVENT_ONE_BY_MORE);
        } else if (id == R.id.btn_clear_all) {
            RxBusUtils.get().post(EventKey.EVENT_CLEAR);
        }
    }

}
