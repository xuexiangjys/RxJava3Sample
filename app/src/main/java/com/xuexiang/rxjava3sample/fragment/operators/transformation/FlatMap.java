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

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 平铺转换操作
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Transforming-Observables#flatmap
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974466
 * <p>
 * FlatMap发出Observables而不是值
 */
@Page(name = "flatMap\n平铺转换操作，适用于一对多，多对多的转换")
public class FlatMap extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "flatMap将一个发射数据的Observable变换为多个Observables，然后将它们发射的数据合并后放进一个单独的Observable";
    }

    @Override
    protected void doOperation(View view) {
        Observable<String> observable = Observable.just(1, 2, 3)
                .flatMap(x -> {
                    int delay = x == 2 ? 1 : 0;
                    printNormal("flatMap:" + x);
                    return Observable.range(x * 10, 3)
                            .map(y -> "项目" + y).delay(delay, TimeUnit.SECONDS);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        doSubscribe(observable);
    }
}
