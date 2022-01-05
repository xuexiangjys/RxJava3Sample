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

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * 指定时长仍没有发射数据，就发一个错误通知
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974504
 */
@Page(name = "timeout\n指定时长仍没有发射数据，就发一个错误通知")
public class Timeout extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "对原始Observable的一个镜像，如果过了一个指定的时长仍没有发射数据，它会发一个错误通知。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("发射延迟10s，但是超时时间是5s:");
        Observable<Long> original = Observable.timer(10, TimeUnit.SECONDS);

        setDisposable(doSubscribe(original.timeout(5, TimeUnit.SECONDS)));
    }

}