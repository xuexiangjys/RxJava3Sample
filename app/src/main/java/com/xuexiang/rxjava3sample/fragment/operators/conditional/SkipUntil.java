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

package com.xuexiang.rxjava3sample.fragment.operators.conditional;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;


/**
 * 条件判断，丢弃原始Observable发射的数据，直到第二个Observable发射了一项数据
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Conditional-and-Boolean-Operators#skipUntil
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974513
 */
@Page(name = "skipUntil\n当第二个Observable发射数据时开始发射")
public class SkipUntil extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "skipUntil订阅原始的Observable，但是忽略它的发射物，直到第二个Observable发射了一项数据那一刻，它开始发射原始Observable。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("第一个每300ms发射，第二个每2s发射，发射结果：");
        Observable<Long> observable1 = Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> observable2 = Observable.interval(2, TimeUnit.SECONDS);
        setDisposable(doSubscribe(observable1.skipUntil(observable2)));
    }
}

