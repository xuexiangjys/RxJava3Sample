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

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

/**
 * 只能接收到订阅之后的所有数据
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974450
 */
@Page(name = "PublishSubject\n只能接收到订阅之后的所有数据")
public class PublishSubjectFragment extends AbstractRxJavaFragment {

    private final Subject<Integer> mPublishSubject = PublishSubject.create();

    @Override
    protected String getInstruction() {
        return "PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者。";
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

        doSubscribe(mPublishSubject, first);

        mPublishSubject.onNext(1);
        mPublishSubject.onNext(2);
        mPublishSubject.onNext(3);

        doSubscribe(mPublishSubject, second);

        mPublishSubject.onNext(4);
        mPublishSubject.onNext(5);
        mPublishSubject.onComplete();
    }
}
