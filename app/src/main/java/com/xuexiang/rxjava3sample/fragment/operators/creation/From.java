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

import com.xuexiang.rxjava3sample.core.BaseOperatorFragment;
import com.xuexiang.rxjava3sample.utils.ExecutorUtils;
import com.xuexiang.xpage.annotation.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 转换创建发射器的操作符
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Creating-Observables#from
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974457
 */
@Page(name = "from\n转换创建发射器")
public class From extends BaseOperatorFragment {

    @Override
    protected String getOperatorInstruction() {
        return "将其它种类的对象和数据类型转换为Observable, 可以是Iterable、Array、Future、Action等。";
    }

    @Override
    protected void doOperation(View view) {
        printNormal("====[fromIterable]====");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Observable<Integer> iterableObservable = Observable.fromIterable(list);
        doSubscribe(iterableObservable);

        printNormal("====[fromArray]====");
        Observable<String> arrayObservable = Observable.fromArray("aaa", "bbb", "ccc");
        doSubscribe(arrayObservable);

        printNormal("====[fromAction]====");
        Action action = () -> printNormal("this is a action!");
        Completable actionCompletable = Completable.fromAction(action);
        doCompletableSubscribe(actionCompletable);

        printNormal("====[fromFuture]====");
        Future<String> future = ExecutorUtils.getSingleExecutor().schedule(() -> "Future delay one second!", 1, TimeUnit.SECONDS);
        Observable<String> futureObservable = Observable.fromFuture(future)
                // 不设置的话会阻塞主线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        doSubscribe(futureObservable);
    }

}
