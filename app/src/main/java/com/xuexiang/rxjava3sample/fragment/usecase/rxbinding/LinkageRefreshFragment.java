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
import com.xuexiang.rxjava3sample.databinding.FragmentLinkageRefreshBinding;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xui.widget.textview.LoggerTextView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;

/***
 * 使用combineLatest处理联动刷新
 */
@Page(name = "Linkage Refresh\n联动刷新(combineLatest)")
public class LinkageRefreshFragment extends LoggerFragment<FragmentLinkageRefreshBinding> {

    @NonNull
    @Override
    protected FragmentLinkageRefreshBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentLinkageRefreshBinding.inflate(inflater, container, false);
    }

    @NonNull
    @Override
    protected LoggerTextView getLogger() {
        return getBinding().logger;
    }

    @Override
    protected void initViews() {
        Observable<CharSequence> observable1 = RxTextView.textChanges(getBinding().etPhoneNumber);

        Observable<CharSequence> observable2 = RxTextView.textChanges(getBinding().etVerifyCode);

        Observable<Boolean> combine = Observable.combineLatest(observable1, observable2, (charSequence, charSequence2) -> {
            boolean phoneNumber = getBinding().etPhoneNumber.validate();
            boolean verifyCode = getBinding().etVerifyCode.validate();
            printNormal("手机号码验证:" + phoneNumber + ", 验证码验证:" + verifyCode);
            return phoneNumber && verifyCode;
        }).observeOn(AndroidSchedulers.mainThread());

        doSubscribe(combine, result -> getBinding().btnLogin.setEnabled(result));
    }
}
