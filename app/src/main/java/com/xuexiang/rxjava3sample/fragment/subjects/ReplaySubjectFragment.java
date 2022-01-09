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

import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;

/**
 * 接收到所有的数据，包括订阅之前的所有数据和订阅之后的所有数据
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974450
 */
@Page(name = "ReplaySubject\n接收订阅前和订阅后的所有数据")
public class ReplaySubjectFragment extends AbstractRxJavaFragment {

    private final Subject<Integer> mReplaySubject = ReplaySubject.create();

    @Override
    protected String getInstruction() {
        return "ReplaySubject会发射所有来自原始Observable的数据给观察者，无论它们是何时订阅的。";
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

        doSubscribe(mReplaySubject, first);

        mReplaySubject.onNext(1);
        mReplaySubject.onNext(2);
        mReplaySubject.onNext(3);

        doSubscribe(mReplaySubject, second);

        mReplaySubject.onNext(4);
        mReplaySubject.onNext(5);
        mReplaySubject.onComplete();
    }
}
