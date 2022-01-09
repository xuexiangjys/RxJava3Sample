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

import java.io.IOException;

import io.reactivex.rxjava3.core.Completable;

/**
 * 让Completable在遇到错误时可以指定某类错误可以正常执行完毕
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Error-Handling-Operators#onerrorcomplete
 */
@Page(name = "onErrorComplete\n发射器在遇到错误时，可以指定某类错误可以正常执行完毕")
public class OnErrorComplete extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "发射器在遇到错误时，可以指定某类错误可以正常执行完毕。";
    }

    @Override
    protected void doOperation(View view) {
        Completable.fromAction(() -> {
            throw new IOException();
        }).onErrorComplete(error -> error instanceof IOException)
                .subscribe(() -> printSuccess("onComplete, IOException was ignored!"),
                        error -> printError("onError should not be printed!"));
    }
}