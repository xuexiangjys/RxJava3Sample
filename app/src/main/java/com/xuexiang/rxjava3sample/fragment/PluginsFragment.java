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
import com.xuexiang.rxjava3sample.fragment.plugins.HookError;
import com.xuexiang.xpage.annotation.Page;

/**
 * 插件，又称Hook, 可以修改Rxjava的默认行为。可使用RxJavaPlugins实现Hook功能，包括发射器的生命周期、自定义线程调度器和全局异常捕获等。
 *
 * 具体参见：
 * <p>
 * https://github.com/ReactiveX/RxJava/wiki/Plugins
 *
 * @author xuexiang
 * @since 2022/1/9 1:44 上午
 */
@Page(name = "Plugins\n插件，可使用RxJavaPlugins实现Hook（插桩）功能")
public class PluginsFragment extends BaseContainerFragment {
    @Override
    protected Class[] getPagesClasses() {
        return new Class[]{
                HookError.class
        };
    }
}
