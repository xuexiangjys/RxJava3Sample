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

package com.xuexiang.rxjava3sample.fragment.usecase.cache;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.xuexiang.rxjava3sample.core.LoggerFragment;
import com.xuexiang.rxjava3sample.databinding.FragmentCacheStrategyBinding;
import com.xuexiang.rxjava3sample.utils.ExecutorUtils;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xui.widget.textview.LoggerTextView;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;

/***
 * 一般网络请求必然会涉及到缓存加载的策略，下面我简单列举几个加载策略
 * 1.先请求网络，请求网络失败后再加载缓存（网络优先）
 * 2.先加载缓存，缓存没有再去请求网络（缓存优先）
 * 3.先使用缓存，不管是否存在，仍然请求网络，等网络请求回来发现数据是一样的就不会再返回，否则再返回
 */
@Page(name = "Cache Strategy\n缓存加载策略")
public class CacheStrategyFragment extends LoggerFragment<FragmentCacheStrategyBinding> {

    @NonNull
    @Override
    protected FragmentCacheStrategyBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentCacheStrategyBinding.inflate(inflater, container, false);
    }

    @NonNull
    @Override
    protected LoggerTextView getLogger() {
        return getBinding().logger;
    }

    @Override
    protected void initViews() {
        getBinding().btnTest1.setOnClickListener(v -> onClickTest1());
        getBinding().btnTest2.setOnClickListener(v -> onClickTest2());
    }

    public void onClickTest1() {
        clearLog();

        printNormal("假设缓存和网络请求结果不一样:");
        addDisposable(doSubscribe(load("data from cache", "data from network"), x -> printNormal("输出:" + x)));
    }

    public void onClickTest2() {
        clearLog();

        printNormal("假设缓存和网络请求结果一样:");
        addDisposable(doSubscribe(load("this is data", "this is data"), x -> printNormal("输出:" + x)));
    }

    /**
     * 先使用缓存，不管是否存在，仍然请求网络，等网络请求回来发现数据是一样的就不会再返回，否则再返回
     * 使用concat+distinct进行处理
     */
    private Observable<String> load(String diskOutput, String networkOutput) {
        return Observable.concat(disk(diskOutput), network(networkOutput))
                .distinct()
                .observeOn(AndroidSchedulers.mainThread());
    }


    /**
     * 磁盘缓存
     */
    private Observable<String> disk(String content) {
        return Observable.create(emitter -> {
            ScheduledFuture<?> future = ExecutorUtils.getCacheExecutor().schedule(() -> {
                printNormal("get data from disk...");
                emitter.onNext(content);
                emitter.onComplete();
            }, 1, TimeUnit.SECONDS);
            emitter.setCancellable(() -> future.cancel(false));
        });
    }

    /**
     * 网络请求
     */
    private Observable<String> network(String content) {
        return Observable.create(emitter -> {
            ScheduledFuture<?> future = ExecutorUtils.getCacheExecutor().schedule(() -> {
                printNormal("get data from network...");
                emitter.onNext(content);
                emitter.onComplete();
            }, 2, TimeUnit.SECONDS);
            emitter.setCancellable(() -> future.cancel(false));
        });
    }


}
