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

import com.xuexiang.rxjava3sample.core.UseCaseTestFragment;
import com.xuexiang.rxjava3sample.utils.ExecutorUtils;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;

/***
 * 一般我们在进行图片加载的时候，都会使用到缓存，通常我们是按照以下顺序去取缓存：
 * 1.内存缓存
 * 2.磁盘缓存
 * 3.网络缓存
 * 我们会按照以上顺序去获取缓存，直到我们过去到一种缓存为止。
 * 分析一下，无非就是有两点要求：1.按顺序获取 2.只获取第一个
 * 这就对应了Rxjava中的concat和first这两个操作符
 */
@Page(name = "Cache Load\n缓存加载检测")
public class CacheLoadFragment extends UseCaseTestFragment {

    @Override
    public void onClickTest() {
        super.onClickTest();
        Maybe<String> observable = Observable.concat(memory(false), disk(false), network(true))
                .firstElement()
                .observeOn(AndroidSchedulers.mainThread());
        setDisposable(doMaybeSubscribe(observable));
    }

    private Observable<String> memory(boolean hasCache) {
        return Observable.create(emitter -> {
            printNormal("check cache from memory...");
            ScheduledFuture<?> future = ExecutorUtils.getCacheExecutor().schedule(() -> {
                if (hasCache) {
                    emitter.onNext("Cache from memory");
                } else {
                    emitter.onComplete();
                }
            }, 500, TimeUnit.MILLISECONDS);
            emitter.setCancellable(() -> future.cancel(false));
        });
    }

    private Observable<String> disk(boolean hasCache) {
        return Observable.create(emitter -> {
            printNormal("check cache from disk...");
            ScheduledFuture<?> future = ExecutorUtils.getCacheExecutor().schedule(() -> {
                if (hasCache) {
                    emitter.onNext("Cache from disk");
                } else {
                    emitter.onComplete();
                }
            }, 1, TimeUnit.SECONDS);
            emitter.setCancellable(() -> future.cancel(false));
        });
    }

    private Observable<String> network(boolean hasCache) {
        return Observable.create(emitter -> {
            printNormal("check cache from network...");
            ScheduledFuture<?> future = ExecutorUtils.getCacheExecutor().schedule(() -> {
                if (hasCache) {
                    emitter.onNext("Cache from network");
                } else {
                    emitter.onComplete();
                }
            }, 2, TimeUnit.SECONDS);
            emitter.setCancellable(() -> future.cancel(false));
        });
    }

}
