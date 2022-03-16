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
import com.xuexiang.rxjava3sample.utils.rxbus.SubscribeInfo;

import io.reactivex.rxjava3.functions.Consumer;

/**
 * 演示3
 *
 * @author xuexiang
 * @since 2022/3/17 2:04 上午
 */
public class RxBusTestFragment3 extends BaseRxBusTestFragment {

    private SubscribeInfo<String> mOneByMore;
    @Override
    protected void initViews() {
        super.initViews();
        setBackgroundColor(android.R.color.holo_orange_light);

        RxBusUtils.get().onMainThread(EventKey.EVENT_BACK_MAINTHREAD, String.class, eventName -> showContent(EventKey.EVENT_BACK_MAINTHREAD, "   EventName:" + eventName + ", 当前线程状态： " + Event.getLooperStatus()));
        mOneByMore = RxBusUtils.get().onMainThread(EventKey.EVENT_ONE_BY_MORE, String.class, new Consumer<String>() {
            @Override
            public void accept(String eventName) throws Exception {
                showContent(EventKey.EVENT_ONE_BY_MORE, "   EventName:" + eventName);
            }
        });
    }

    @Override
    protected void onCancelEvent() {
        RxBusUtils.get().unregisterAll(EventKey.EVENT_BACK_MAINTHREAD);
        RxBusUtils.get().unregister(EventKey.EVENT_ONE_BY_MORE, mOneByMore);
        RxBusUtils.get().unregister(EventKey.EVENT_CLEAR, mSubscribeInfo);
    }
}
