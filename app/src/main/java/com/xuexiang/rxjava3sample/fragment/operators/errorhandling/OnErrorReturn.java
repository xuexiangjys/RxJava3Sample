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

package com.xuexiang.rxjava3sample.fragment.operators.errorhandling;

import android.view.View;

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;


/**
 * 让Observable遇到错误时发射一个特殊的项并且正常终止
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Error-Handling-Operators#onerrorreturn
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974493
 */
@Page(name = "onErrorReturn\n发射器在遇到错误时，发射一个特殊的项并且正常终止")
public class OnErrorReturn extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "onErrorReturn方法返回一个镜像原有Observable行为的新Observable，后者会忽略前者的onError调用，不会将错误传递给观察者，作为替代，它会发发射一个特殊的项并调用观察者的onCompleted方法。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("出现错误直接返回404:");
        Observable<Integer> original = Observable.just("12", "A2", "234")
                .map(Integer::parseInt);

        // 和onErrorResumeNext不同的是，onErrorReturn直接返回数据
        doSubscribe(original.onErrorReturn(throwable -> {
            printError(throwable.getMessage());
            return 404;
        }));
    }
}