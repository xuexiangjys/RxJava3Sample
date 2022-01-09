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

import com.xuexiang.rxjava3sample.core.AbstractRxJavaFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

/**
 * 窗口操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Transforming-Observables#window
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974470
 * <p>
 * Window和Buffer类似，但不是发射来自原始Observable的数据包，它发射的是Observables，这些Observables中的每一个都发射原始Observable数据的一个子集，最后发射一个onCompleted通知。
 */
@Page(name = "window\n窗口操作符，根据一定的规则，将发射器分为多段进行发送")
public class Window extends AbstractRxJavaFragment {

    @Override
    protected String getInstruction() {
        return "定期将来自原始Observable的数据分解为一个Observable窗口，发射这些窗口，而不是每次发射一项数据";
    }

    @Override
    protected void doOperation(View view) {
        Observable<List<Integer>> windowObservable = Observable.range(1, 10)
                // skip=2代表原数据源每发射到第2个时跳过，并新开一个窗口
                // count=3代表每个窗口最多发3个数据项后，就关闭窗口并新开一个窗口（窗体大小）
                .window(3, 2)
                .flatMapSingle(Observable::toList);

        // 当count=skip，效果就等于buffer，数据没有丢失和重复
        // 当count>skip，每个窗口数据有 count-skip 重复
        // 当count<skip，每个窗口数据有 skip-count 丢失

        doSubscribe(windowObservable);
    }
}
