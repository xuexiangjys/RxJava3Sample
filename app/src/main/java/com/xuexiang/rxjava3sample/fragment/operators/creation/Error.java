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
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 错误发射器
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Creating-Observables#error
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974456
 */
@Page(name = "error\n错误发射器")
public class Error extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "创建一个不发射数据以一个错误终止的Observable";
    }

    @Override
    protected void doOperation(View view) {
        Observable<String> observable = Observable.fromCallable(() -> {
            if (Math.random() < 0.5) {
                throw new Exception("number is less than 0.5!");
            }
            throw new IllegalArgumentException("number is illegal!");
        });

        // 抛出Exception错误，不抛出IllegalArgumentException错误
        Observable<String> result = observable.onErrorResumeNext(error -> {
            if (error instanceof IllegalArgumentException) {
                return Observable.empty();
            }
            return Observable.error(error);
        });

        for (int i = 0; i < 10; i++) {
            doSubscribe(result, v -> printNormal("This should never be printed!"));
        }

    }
}
