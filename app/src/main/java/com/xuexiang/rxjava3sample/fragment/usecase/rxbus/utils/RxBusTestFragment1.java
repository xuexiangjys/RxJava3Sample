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

import com.xuexiang.rxjava3sample.fragment.usecase.rxbus.utils.entity.Event;
import com.xuexiang.rxjava3sample.fragment.usecase.rxbus.utils.entity.EventKey;
import com.xuexiang.rxjava3sample.utils.rxbus.RxBusUtils;

/**
 * 注册了三个事件：EVENT_HAVE_DATA，EVENT_ONE_BY_ONE，EVENT_CLEAR
 *
 * @author xuexiang
 * @since 2022/3/17 2:05 上午
 */
public class RxBusTestFragment1 extends BaseRxBusTestFragment {

    @Override
    protected void initViews() {
        super.initViews();
        setBackgroundColor(android.R.color.holo_green_light);

        RxBusUtils.get().onMainThread(EventKey.EVENT_HAVE_DATA, Event.class, event -> showContent(EventKey.EVENT_HAVE_DATA, event.toString()));
        RxBusUtils.get().onMainThread(EventKey.EVENT_ONE_BY_ONE, String.class, eventName -> showContent(EventKey.EVENT_ONE_BY_ONE, "   EventName:" + eventName));
    }

    @Override
    protected void onCancelEvent() {
        RxBusUtils.get().unregisterAll(EventKey.EVENT_HAVE_DATA);
        RxBusUtils.get().unregisterAll(EventKey.EVENT_ONE_BY_ONE);
        RxBusUtils.get().unregister(EventKey.EVENT_CLEAR, mSubscribeInfo);
    }


}
