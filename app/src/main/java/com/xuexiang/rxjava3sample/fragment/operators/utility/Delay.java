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

package com.xuexiang.rxjava3sample.fragment.operators.utility;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * 延迟发射操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Error-Handling-Operators#delay
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974496
 */
@Page(name = "delay\n延迟一段指定的时间再发射来自Observable的发射物.")
public class Delay extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "delay操作符让原始Observable在发射每项数据之前都暂停一段指定的时间段。";
    }

    @Override
    protected void doOperation(View view) {
        addDisposable(Observable.interval(0, 1, TimeUnit.SECONDS)
                .takeUntil(x -> x >= 4)
                .subscribe(value -> printNormal(String.format("%s秒后发送数据...", 5 - value))));

        Observable<Integer> delayObservable = Observable.range(0, 5)
                // 延迟5秒钟后发射
                .delay(5, TimeUnit.SECONDS);
        setDisposable(doSubscribe(delayObservable));
    }
}
