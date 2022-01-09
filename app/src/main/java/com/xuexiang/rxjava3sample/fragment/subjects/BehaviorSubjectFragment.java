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

import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.Subject;

/**
 * 接收到订阅前的最后一条数据(作为默认值)和订阅后的所有数据
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974450
 */
@Page(name = "BehaviorSubject\n接收到订阅前的最后一条数据和订阅后的所有数据")
public class BehaviorSubjectFragment extends AbstractRxJavaFragment {

    private final Subject<Integer> mBehaviorSubject = BehaviorSubject.create();

    @Override
    protected String getInstruction() {
        return "当观察者订阅BehaviorSubject时，它开始发射原始Observable最近发射的数据（如果此时还没有收到任何数据，它会发射一个默认值），然后继续发射其它任何来自原始Observable的数据。";
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

        doSubscribe(mBehaviorSubject, first);

        mBehaviorSubject.onNext(1);
        mBehaviorSubject.onNext(2);
        mBehaviorSubject.onNext(3);

        doSubscribe(mBehaviorSubject, second);

        mBehaviorSubject.onNext(4);
        mBehaviorSubject.onNext(5);
        mBehaviorSubject.onComplete();
    }
}