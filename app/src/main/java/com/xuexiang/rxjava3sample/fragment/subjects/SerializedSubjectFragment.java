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

package com.xuexiang.rxjava3sample.fragment.subjects;

import android.view.View;

import androidx.annotation.NonNull;

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.rxjava3sample.core.LogObserver;
import com.xuexiang.xaop.annotation.SingleClick;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

/**
 * 线程安全的Subject, 可以保证订阅者的生命周期线程安全，即onSubscribe，onNext，onError和onComplete的线程安全
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974450
 */
@Page(name = "SerializedSubject\n线程安全的Subject，可由其他Subject调用toSerialized转换而来")
public class SerializedSubjectFragment extends AbstractRxJavaFragment {

    private final Subject<Integer> mSerializedSubject = PublishSubject.<Integer>create().toSerialized();

    private final Subject<Integer> mSubject = PublishSubject.create();

    private int mPosition = 0;

    private LogObserver<Integer> mSafeObserver;

    private LogObserver<Integer> mUnSafeObserver;

    @Override
    protected String getInstruction() {
        return "线程安全的Subject，可由其他Subject调用toSerialized转换而来。";
    }

    @Override
    protected void initViews() {
        super.initViews();
        getBinding().btnStart.setText("线程安全");
        getBinding().btnEnd.setText("非线程安全");
        getBinding().btnEnd.setOnClickListener(this::doUnSafeOperation);
    }

    @Override
    protected void doOperation(View view) {
        // 下面的案例只能保证mPosition的线程安全，并不能保证发射出的数据value线程安全。
        if (mSafeObserver == null) {
            mSafeObserver = new LogObserver<Integer>(this, "SafeSubject") {
                @Override
                public void onNext(@NonNull Integer value) {
                    String log = getTagPrefix() + "==onNext==>value:" + value + ", position:" + mPosition + ", threadId:" + Thread.currentThread().getId();
                    printNormal(log);
                    mPosition++;
                }
            };
            doSubscribe(mSerializedSubject, mSafeObserver);
        }

        mPosition = 0;

        for (int i = 0; i < 6; i++) {
            final int finalValue = i;
            new Thread() {
                public void run() {
                    mSerializedSubject.onNext(finalValue);
                }
            }.start();
        }
    }

    @Override
    protected boolean isContinuousOperation() {
        return true;
    }

    @SingleClick
    private void doUnSafeOperation(View view) {
        clearLog();
        if (mUnSafeObserver == null) {
            mUnSafeObserver = new LogObserver<Integer>(this, "UnSafeSubject") {
                @Override
                public void onNext(@NonNull Integer value) {
                    String log = getTagPrefix() + "==onNext==>value:" + value + ", position:" + mPosition + ", threadId:" + Thread.currentThread().getId();
                    printNormal(log);
                    mPosition++;
                }
            };
            doSubscribe(mSubject, mUnSafeObserver);
        }

        mPosition = 0;

        for (int i = 0; i < 6; i++) {
            final int finalValue = i;
            new Thread() {
                public void run() {
                    mSubject.onNext(finalValue);
                }
            }.start();
        }
    }


}