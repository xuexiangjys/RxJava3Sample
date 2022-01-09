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

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.rxjava3sample.core.LogObserver;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.Subject;

/**
 * 不管在什么位置订阅，都只接收到最后一条数据
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974450
 */
@Page(name = "AsyncSubject\n只接收到最后一条数据")
public class AsyncSubjectFragment extends AbstractRxJavaFragment {

    private final Subject<Integer> mAsyncSubject = AsyncSubject.create();

    @Override
    protected String getInstruction() {
        return "一个AsyncSubject只在原始Observable完成后，发射来自原始Observable的最后一个值。（如果原始Observable没有发射任何值，AsyncObject也不发射任何值）它会把这最后一个值发射给任何后续的观察者。";
    }

    @Override
    protected void beforeOperation() {
        super.beforeOperation();
        getBinding().btnStart.setEnabled(false);
    }

    @Override
    protected void doOperation(View view) {
        LogObserver<Integer> first = new LogObserver<>(this, "First");
        LogObserver<Integer> second = new LogObserver<>(this, "Second");

        doSubscribe(mAsyncSubject, first);

        mAsyncSubject.onNext(1);
        mAsyncSubject.onNext(2);
        mAsyncSubject.onNext(3);

        doSubscribe(mAsyncSubject, second);

        mAsyncSubject.onNext(4);
        mAsyncSubject.onNext(5);
        mAsyncSubject.onComplete();
    }
}