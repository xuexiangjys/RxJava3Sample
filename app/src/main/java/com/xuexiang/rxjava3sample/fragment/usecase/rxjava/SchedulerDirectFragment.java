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

package com.xuexiang.rxjava3sample.fragment.usecase.rxjava;

import com.xuexiang.rxjava3sample.core.UseCaseTestFragment;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Scheduler都可以调用scheduleXXXDirect直接执行
 *
 * @author xuexiang
 * @since 2022/3/17 11:07 下午
 */
@Page(name = "Scheduler\n直接在线程中执行")
public class SchedulerDirectFragment extends UseCaseTestFragment {

    @Override
    public void onClickTest() {
        super.onClickTest();

        // 执行一个周期任务，和interval类似
        Disposable disposable = Schedulers.newThread().schedulePeriodicallyDirect(() -> {
            printNormal("定期执行任务中....");
        }, 0, 1, TimeUnit.SECONDS);

        setDisposable(disposable);
    }
}
