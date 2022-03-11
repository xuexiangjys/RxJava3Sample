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

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.xuexiang.rxjava3sample.core.BaseFragment;
import com.xuexiang.rxjava3sample.core.SimpleObserver;
import com.xuexiang.rxjava3sample.databinding.FragmentCountDownBinding;
import com.xuexiang.xpage.annotation.Page;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

/***
 * 使用interval+take轮询刷新
 */
@Page(name = "Count Down\n倒计时(interval+take)")
public class CountDownFragment extends BaseFragment<FragmentCountDownBinding> {

    private Disposable disposable;

    @NonNull
    @Override
    protected FragmentCountDownBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentCountDownBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {
        getBinding().btnCountDown.setOnClickListener(v -> startCountDown());
    }

    private void startCountDown() {
        disposable = countDown(20, 1, TimeUnit.SECONDS)
                .subscribeWith(new SimpleObserver<Long>() {
                    @Override
                    protected void onStart() {
                        getBinding().btnCountDown.setEnabled(false);
                    }

                    @Override
                    public void onNext(@NonNull Long timeLeft) {
                        getBinding().btnCountDown.setText(String.format("%s s后重新获取", timeLeft));
                    }

                    @Override
                    public void onComplete() {
                        getBinding().btnCountDown.setText("重新获取");
                        getBinding().btnCountDown.setEnabled(true);
                    }
                });
    }

    @Override
    public void onDestroyView() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
        super.onDestroyView();
    }

    /**
     * 倒计时操作
     *
     * @param totalTime 倒计时总时长
     * @param interval  倒计时间隔
     * @param unit      时间间隔单位
     */
    public static Observable<Long> countDown(final long totalTime, long interval, @NonNull TimeUnit unit) {
        return Observable.interval(0, interval, unit)
                .take((int) Math.floor(totalTime / (double) interval) + 1)
                .map(time -> totalTime - time)
                .observeOn(AndroidSchedulers.mainThread());
    }
}
