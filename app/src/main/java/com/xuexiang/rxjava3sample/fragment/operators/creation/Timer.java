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

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * 创建一个延迟发射器
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Creating-Observables#timer
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974463
 */
@Page(name = "timer\n延迟发射器")
public class Timer extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "创建一个Observable，它在一个给定的延迟后发射一个特殊的值。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("3秒钟后发射数据...");

        Observable<Long> delay = Observable.timer(3, TimeUnit.SECONDS);
        setDisposable(doSubscribe(delay));
    }
}
