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

package com.xuexiang.rxjava3sample.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 线程工具类
 *
 * @author xuexiang
 * @since 2021/12/20 9:57 下午
 */
public final class ExecutorUtils {

    private static final AtomicInteger threadNumber = new AtomicInteger(1);

    private static final ScheduledExecutorService sSingleExecutor = Executors.newSingleThreadScheduledExecutor();

    private static final ScheduledExecutorService sCacheExecutor = Executors.newScheduledThreadPool(4);

    private ExecutorUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static ScheduledExecutorService getSingleExecutor() {
        return sSingleExecutor;
    }

    public static ScheduledExecutorService getCacheExecutor() {
        return sCacheExecutor;
    }

    /**
     * 用指定的名称新建一个线程
     *
     * @param name 线程名
     * @return Scheduler
     */
    public static Scheduler getScheduler(final String name) {
        return Schedulers.from(Executors.newCachedThreadPool(runnable -> new Thread(runnable, name)));
    }

    /**
     * 用指定的名称新建一个线程
     *
     * @param namePrefix 线程名前缀
     * @return Scheduler
     */
    public static Scheduler getIoScheduler(final String namePrefix) {
        return Schedulers.from(Executors.newCachedThreadPool(runnable -> new Thread(runnable, namePrefix + threadNumber.getAndIncrement())));
    }

}