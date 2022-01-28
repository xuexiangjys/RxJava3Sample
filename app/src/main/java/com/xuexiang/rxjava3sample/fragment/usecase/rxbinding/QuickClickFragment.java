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

import com.jakewharton.rxbinding4.view.RxView;
import com.xuexiang.rxjava3sample.core.UseCaseTestFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Unit;

/***
 * 使用throttleFirst处理快速点击
 */
@Page(name = "Quick Click\n快速点击(throttleFirst)")
public class QuickClickFragment extends UseCaseTestFragment {

    @Override
    protected void initViews() {
        Observable<Unit> observable = RxView.clicks(getBinding().btnTest)
                .throttleFirst(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread());
        doSubscribe(observable, unit -> printSuccess("响应点击事件"));
    }

}
