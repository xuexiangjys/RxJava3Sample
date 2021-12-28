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

package com.xuexiang.rxjava3sample.fragment.operators.errorhandling;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * 重试操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Error-Handling-Operators#retry
 */
@Page(name = "retry\n如果原始Observable遇到错误，重新订阅它期望它能正常终止")
public class Retry extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "Retry操作符不会将原始Observable的onError通知传递给观察者，它会订阅这个Observable，再给它一次机会无错误地完成它的数据序列。Retry总是传递onNext通知给观察者，由于重新订阅，可能会造成数据项重复。";
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

        Observable<Long> source = Observable.interval(0, 1, TimeUnit.SECONDS)
                .flatMap(x -> x >= 2 ? Observable.error(new Exception("Something went wrong!")) : Observable.just(x))
                // 重试次数不能超过3次
                .retry((retryCount, error) -> retryCount < 3);

        setDisposable(doSubscribe(source));
    }
}
