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

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/**
 * 使用RxJavaPlugins.setErrorHandler可进行Error的全局Hook.
 */
@Page(name = "HookError\n全局异常捕获")
public class HookError extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "使用RxJavaPlugins.setErrorHandler可进行Error的全局Hook, 当然也不是所有error都可以Hook到的。";
    }

    @Override
    protected void initArgs() {
        // 进行全局的异常捕获
        RxJavaPlugins.setErrorHandler(e -> printError("Hook error:" + e.getMessage()));
    }

    @Override
    protected void doOperation(View view) {
        // 可以Hook
        Observable.just("A2").map(Integer::parseInt)
                .subscribe(x -> printNormal("onNext:" + x));

        // 不可以Hook
        Observable.just("B5").map(Integer::parseInt)
                .subscribe(x -> printNormal("onNext:" + x),
                        e -> printError("onError:" + e.getMessage()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        RxJavaPlugins.reset();
    }
}
