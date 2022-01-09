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

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * 条件判断，当第二个Observable发射了一项数据或者终止时中断数据发射
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Conditional-and-Boolean-Operators#takeuntil
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974513
 */
@Page(name = "takeUntil\n当第二个Observable发射数据时终止发射")
public class TakeUntil extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "takeUntil订阅并开始发射原始Observable，它还监视你提供的第二个Observable。如果第二个Observable发射了一项数据或者发射了一个终止通知，takeUntil返回的Observable会停止发射原始Observable并终止。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("第一个每300ms发射，第二个每2s发射，发射结果：");
        Observable<Long> observable1 = Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> observable2 = Observable.interval(2, TimeUnit.SECONDS);
        setDisposable(doSubscribe(observable1.takeUntil(observable2)));
    }
}

