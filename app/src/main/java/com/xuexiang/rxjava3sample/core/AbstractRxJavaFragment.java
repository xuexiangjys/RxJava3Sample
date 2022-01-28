/*
 * Copyright (C) 2021 xuexiangjys(xuexiangjys@163.com)
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.xuexiang.rxjava3sample.databinding.FragmentTemplateBinding;
import com.xuexiang.xaop.annotation.MemoryCache;
import com.xuexiang.xaop.annotation.SingleClick;
import com.xuexiang.xui.utils.ViewUtils;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xui.widget.textview.LoggerTextView;
import com.xuexiang.xutil.resource.ResourceUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * RxJava抽象基类
 *
 * @author xuexiang
 * @since 2022/1/9 2:00 下午
 */
public abstract class AbstractRxJavaFragment extends LoggerFragment<FragmentTemplateBinding> {
    /**
     * 是否显示源码
     */
    private boolean mIsShowCode;

    private TextView mAction;

    @NonNull
    @Override
    protected FragmentTemplateBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentTemplateBinding.inflate(inflater, container, false);
    }

    @NonNull
    @Override
    protected LoggerTextView getLogger() {
        return getBinding().logger;
    }

    @Override
    protected void initViews() {
        getBinding().tvInstruction.setText(getInstruction());
        addDisposable(Observable.just(getOperatorName())
                .map(x -> String.format("%s.txt", x))
                .map(this::getCodeContent)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(code -> getBinding().codeView.setCode(code)));
        refreshCodeView(mIsShowCode);

        getBinding().btnStart.setOnClickListener(this::handleOperationStart);
        getBinding().btnEnd.setOnClickListener(this::stopOperation);
        ViewUtils.setVisibility(getBinding().btnEnd, isContinuousOperation());
    }

    @Override
    protected TitleBar initTitle() {
        TitleBar titleBar = super.initTitle();
        mAction = (TextView) titleBar.addAction(new TitleBar.TextAction(mIsShowCode ? "简介" : "源码") {
            @Override
            public void performAction(View view) {
                mIsShowCode = !mIsShowCode;
                mAction.setText(mIsShowCode ? "简介" : "源码");
                refreshCodeView(mIsShowCode);
            }
        });
        if (getUseCase() != null) {
            titleBar.addAction(new TitleBar.TextAction("应用") {
                @Override
                public void performAction(View view) {
                    openPage(getUseCase());
                }
            });
        }
        return titleBar;
    }

    protected Class getUseCase() {
        return null;
    }

    private void refreshCodeView(boolean isShowCode) {
        ViewUtils.setVisibility(getBinding().codeView, isShowCode);
        ViewUtils.setVisibility(getBinding().tvInstruction, !isShowCode);
    }

    @SingleClick
    protected void handleOperationStart(View v) {
        if (isOperationNotDisposed()) {
            return;
        }
        beforeOperation();
        doOperation(v);
    }

    /**
     * 操作开始
     */
    protected void beforeOperation() {
        clearLog();
    }

    /**
     * 获取操作符的名称
     *
     * @return 操作符的名称
     */
    protected String getOperatorName() {
        String name = getSimpleName(this);
        return name.replaceAll("Fragment", "");
    }

    /**
     * 获取简介
     *
     * @return 简介
     */
    protected abstract String getInstruction();

    /**
     * 执行操作符操作
     */
    protected abstract void doOperation(View view);

    /**
     * 停止操作符操作
     */
    protected void stopOperation(View view) {
        cancelSubscribe();
    }

    /**
     * 是否是连续的操作符
     */
    protected boolean isContinuousOperation() {
        return false;
    }

    /**
     * 获取对象的类名
     */
    public static String getSimpleName(final Object object) {
        return object != null ? object.getClass().getSimpleName() : "NULL";
    }

    @MemoryCache
    private String getCodeContent(String url) {
        return ResourceUtils.readStringFromAssert(url);

    }

    protected void threadSafeSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}
