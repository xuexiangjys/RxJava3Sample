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

package com.xuexiang.rxjava3sample.fragment.operators.utility;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 注册一个动作作为原始Observable生命周期事件的一种占位符
 * <p>
 * https://reactivex.io/documentation/operators/do.html
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974497
 */
@Page(name = "do\n注册一个动作作为原始Observable生命周期事件的一种占位符")
public class Do extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "doOnEach操作符让你可以注册一个回调，它产生的Observable每发射一项数据就会调用它一次。";
    }

    @Override
    protected void doOperation(View view) {
        Observable<Integer> observable = Observable.range(1, 2)
                .doOnSubscribe(disposable -> printNormal("【doOnSubscribe】: isDisposed:" + disposable.isDisposed()))
                // doOnEach 订阅onNext、onComplete和onError
                .doOnEach(notification -> printWarning("【doOnEach】: " + notification.toString()))
                .doOnNext(integer -> printNormal("【doOnNext】: " + integer))
                .doAfterNext(integer -> printNormal("【doAfterNext】: " + integer))
                .doOnComplete(() -> printNormal("【doOnComplete】"))
                .doOnError(error -> printNormal("【doOnError】: " + error.getMessage()))
                .doOnDispose(() -> printNormal("【doOnDispose】"))
                .doOnTerminate(() -> printNormal("【doOnTerminate】"))
                .doAfterTerminate(() -> printNormal("【doAfterTerminate】"))
                .doFinally(() -> printNormal("【doFinally】"));

        doSubscribe(observable);
    }
}
