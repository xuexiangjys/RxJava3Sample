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

package com.xuexiang.rxjava3sample.fragment.usecase.rxbus;

import com.xuexiang.rxjava3sample.core.UseCaseTestFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

/**
 * 通过Subject实现RxBus的功能
 *
 * @author xuexiang
 * @since 2022/3/17 9:55 下午
 */
@Page(name = "PublishSubject\n通过Subject实现RxBus的功能")
public class RxSubjectFragment extends UseCaseTestFragment {

    private final Subject<String> mPublishSubject = PublishSubject.<String>create().toSerialized();

    @Override
    protected void initViews() {
        super.initViews();
        Disposable disposable = mPublishSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::printNormal);
        setDisposable(disposable);
    }

    @Override
    public void onClickTest() {
        mPublishSubject.onNext("这是发送出去的数据!");
    }
}
