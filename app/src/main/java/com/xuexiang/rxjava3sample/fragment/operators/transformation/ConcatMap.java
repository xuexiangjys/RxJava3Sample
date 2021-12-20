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
 * 有序平铺转换操作
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Transforming-Observables#concatmap
 * <p>
 * 1.concatMap是有序的，flatMap是无序的。concatMap最终输出的顺序与原序列保持一致，而flatMap则不一定，有可能出现交错。
 * 2.concatMap是按照发射顺序发射的，flatMap是按照执行完毕的顺序发射的。
 */
@Page(name = "concatMap\n有序平铺转换操作")
public class ConcatMap extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "ConcatMap将一个发射数据的Observable变换为多个Observables，然后将它们发射的数据【按发射顺序】合并后放进一个单独的Observable。";
    }

    @Override
    protected void doOperation(View view) {
        Observable<String> observable = Observable.just(1, 2, 3)
                .concatMap(x -> {
                    int delay = x == 2 ? 1 : 0;
                    logNormal("concatMap:" + x);
                    return Observable.range(x * 10, 3)
                            .map(y -> "项目" + y).delay(delay, TimeUnit.SECONDS);
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        doSubscribe(observable);
    }
}
