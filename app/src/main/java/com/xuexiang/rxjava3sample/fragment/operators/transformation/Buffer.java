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

package com.xuexiang.rxjava3sample.fragment.operators.transformation;

import android.view.View;

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

/**
 * 缓冲池操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Transforming-Observables#buffer
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974465
 */
@Page(name = "buffer\n缓冲池操作符")
public class Buffer extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "定期收集Observable的数据放进一个数据包裹，然后发射这些数据包裹，而不是一次发射一个值。";
    }

    @Override
    protected void doOperation(View view) {
        Observable<List<Integer>> observable = Observable.range(0, 10)
                // 设置缓存大小
                .buffer(4);
        doSubscribe(observable);
    }
}
