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

package com.xuexiang.rxjava3sample.fragment;

import com.xuexiang.rxjava3sample.core.BaseContainerFragment;
import com.xuexiang.rxjava3sample.fragment.subjects.AsyncSubjectFragment;
import com.xuexiang.rxjava3sample.fragment.subjects.BehaviorSubjectFragment;
import com.xuexiang.rxjava3sample.fragment.subjects.PublishSubjectFragment;
import com.xuexiang.rxjava3sample.fragment.subjects.ReplaySubjectFragment;
import com.xuexiang.rxjava3sample.fragment.subjects.SerializedSubjectFragment;
import com.xuexiang.xpage.annotation.Page;

/**
 * Subject 既是 Observable 又是 Observer(Subscriber)
 * <p>
 * https://www.kancloud.cn/luponu/rxjava_zh/974450
 *
 * @author xuexiang
 * @since 2022/1/9 1:31 上午
 */
@Page(name = "Subjects\n主题，既是事件的发出者，又是事件的订阅者")
public class SubjectsFragment extends BaseContainerFragment {

    @Override
    protected Class[] getPagesClasses() {
        return new Class[]{
                AsyncSubjectFragment.class,
                PublishSubjectFragment.class,
                BehaviorSubjectFragment.class,
                ReplaySubjectFragment.class,
                SerializedSubjectFragment.class
        };
    }
}
