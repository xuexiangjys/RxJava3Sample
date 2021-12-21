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
import com.xuexiang.xpage.annotation.Page;

import io.reactivex.rxjava3.core.Observable;

/**
 * 空发射器
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Creating-Observables#empty
 */
@Page(name = "empty\n空发射器")
public class Empty extends BaseOperatorFragment {
    @Override
    protected String getOperatorInstruction() {
        return "创建一个不发射任何数据但是正常终止的Observable";
    }

    @Override
    protected void doOperation(View view) {
        Observable<String> empty = Observable.empty();
        doSubscribe(empty, v -> logNormal("This should never be printed!"));
    }

}
