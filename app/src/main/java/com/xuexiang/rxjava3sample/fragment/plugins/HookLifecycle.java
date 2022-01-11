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

package com.xuexiang.rxjava3sample.fragment.plugins;

import android.view.View;

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xutil.common.StringUtils;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/**
 * 使用RxJavaPlugins.setOnXxx可以对Observable, Single 和 Completable等发射器的生命周期进行Hook.
 */
@Page(name = "HookLifecycle\nHook发射器的生命周期")
public class HookLifecycle extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "使用RxJavaPlugins.setOnXxx可以对Observable, Single 和 Completable等发射器的生命周期进行Hook。";
    }

    @Override
    protected void doOperation(View view) {
        // Hook发射器装载
        RxJavaPlugins.setOnObservableAssembly(observable -> {
            printError("Hook Assembly Observable:" + StringUtils.getSimpleName(observable));
            return observable;
        });
        // Hook发射器被订阅
        RxJavaPlugins.setOnObservableSubscribe((source, observer) -> {
            printError("Hook Subscribe Observable:" + StringUtils.getSimpleName(source) + ", observer:" + StringUtils.getSimpleName(observer));
            return observer;
        });

        doSubscribe(Observable.range(5, 4)
                .map(x -> x + 1));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        RxJavaPlugins.reset();
    }
}