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

package com.xuexiang.rxjava3sample.core;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.xuexiang.rxjava3sample.core.BaseFragment;
import com.xuexiang.rxjava3sample.databinding.FragmentCodeBinding;
import com.xuexiang.xaop.annotation.MemoryCache;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xrouter.annotation.AutoWired;
import com.xuexiang.xrouter.launcher.XRouter;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xutil.common.StringUtils;
import com.xuexiang.xutil.resource.ResourceUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 代码浏览
 *
 * @author xuexiang
 * @since 2021/12/28 9:49 下午
 */
@Page(name = "演示代码")
public class CodeFragment extends BaseFragment<FragmentCodeBinding> {

    public static final String KEY_OPERATOR_NAME = "key_operator_name";

    @AutoWired(name = KEY_OPERATOR_NAME)
    String operatorName;

    private Disposable mDisposable;

    @NonNull
    @Override
    protected FragmentCodeBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentCodeBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initArgs() {
        XRouter.getInstance().inject(this);
    }

    @Override
    protected TitleBar initTitle() {
        return super.initTitle().setTitle(String.format("演示代码\n%s", StringUtils.lowerFirstLetter(operatorName)));
    }

    @Override
    protected void initViews() {
        mDisposable = Observable.just(operatorName)
                .map(x -> String.format("%s.txt", x))
                .map(this::getCodeContent)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(code -> getBinding().codeView.setCode(code));
    }


    @MemoryCache
    private String getCodeContent(String url) {
        return ResourceUtils.readStringFromAssert(url);

    }

    @Override
    public void onDestroyView() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
        super.onDestroyView();
    }
}
