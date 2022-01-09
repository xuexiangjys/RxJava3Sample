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
 * 创建一个周期发射器
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Creating-Observables#interval
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974458
 */
@Page(name = "interval\n周期发射器")
public class Interval extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "创建一个按固定时间间隔发射整数序列的Observable。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("每1秒发射数据...");

        Observable<Long> clock = Observable.interval(0, 1, TimeUnit.SECONDS);
        setDisposable(doSubscribe(clock));
    }
}
