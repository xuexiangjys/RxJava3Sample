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

package com.xuexiang.rxjava3sample.fragment.operators.creation;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.rxjava3sample.utils.ExecutorUtils;
import com.xuexiang.xaop.annotation.SingleClick;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

/**
 * 自定义创建操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Creating-Observables#create
 */
@Page(name = "create\n自定义发射器")
public class Create extends BaseOperatorFragment {

    private ObservableEmitter<String> mEmitter;

    private int mCount = 1;

    @Override
    protected String getOperatorInstruction() {
        return "使用一个函数从头开始创建一个Observable";
    }

    @Override
    protected void beforeOperation() {

    }

    @Override
    protected void doOperation(View view) {
        if (isOperationNotDisposed()) {
            return;
        }

        clearLog();

        // 循环发送数据
        ObservableOnSubscribe<String> handler = emitter -> {
            mEmitter = emitter;
            ScheduledFuture<?> future = ExecutorUtils.getSingleExecutor().scheduleAtFixedRate(() -> {
                emitter.onNext("Hello World!");
                emitter.onNext("This is No." + mCount);
                mCount++;
            }, 0, 1, TimeUnit.SECONDS);
            emitter.setCancellable(() -> future.cancel(false));
        };

        Observable<String> observable = Observable.create(handler);
        setDisposable(doSubscribe(observable));
    }


    @Override
    protected boolean isContinuousOperation() {
        return true;
    }

    @SingleClick
    @Override
    protected void stopOperation(View view) {
        if (mEmitter != null) {
            mEmitter.onComplete();
            mEmitter = null;
        }
        mCount = 1;
    }
}
