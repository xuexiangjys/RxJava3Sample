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

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * 给Observable发射的数据项附加一个时间戳
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974505
 */
@Page(name = "timestamp\n给Observable发射的数据项附加一个时间戳")
public class Timestamp extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "timestamp给Observable发射的数据项附加一个时间戳。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("每1s周期发射数据：");
        Observable<Long> original = Observable.interval(0, 1, TimeUnit.SECONDS);
        setDisposable(doSubscribe(original.timestamp(TimeUnit.SECONDS)));
    }

    @Override
    protected boolean isContinuousOperation() {
        return true;
    }

}