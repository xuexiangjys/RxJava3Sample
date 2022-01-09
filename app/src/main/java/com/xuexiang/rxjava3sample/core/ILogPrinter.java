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

package com.xuexiang.rxjava3sample.core;

/**
 * 日志打印者
 *
 * @author xuexiang
 * @since 2022/1/9 2:54 下午
 */
public interface ILogPrinter {

    /**
     * 添加普通日志
     *
     * @param logContent 日志内容
     */
    void printNormal(String logContent);

    /**
     * 添加分割线
     */
    void println();

    /**
     * 添加成功日志
     *
     * @param logContent 日志内容
     */
    void printSuccess(String logContent);

    /**
     * 添加警告日志
     *
     * @param logContent 日志内容
     */
    void printWarning(String logContent);

    /**
     * 添加错误日志
     *
     * @param logContent 日志内容
     */
    void printError(String logContent);

}
