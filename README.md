# RxJava3Sample

RxJava3使用演示

## 发射器类型

类型	| 描述
|---|---
Observable<T> | 能够发射0或n个数据，并以成功或错误事件终止。
Flowable<T> | 能够发射0或n个数据，并以成功或错误事件终止。支持Backpressure，可以控制数据源发射的速度。
Single<T> | 只发射单个数据或错误事件。只处理 onNext 和 onError 事件，没有onComplete。
Completable | 它从来不发射数据，只处理 onComplete 和 onError 事件。可以看成是Rx的Runnable。
Maybe<T> | 能够发射0或者1个数据，要么成功，要么失败。类似Single和Completable的结合。如果处理了onNext 和 onError，那么就不处理onComplete。

## 常用操作符

类型	| 操作符
|---|---
创建类型 | [Create](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/creation/Create.java) , [Just](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/creation/Just.java) , [Timer](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/creation/Timer.java) , [Interval](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/creation/Interval.java) , [From](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/creation/From.java) , [Error](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/creation/Error.java)
转换类型 | [Map](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/transformation/Map.java) , [FlatMap](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/transformation/FlatMap.java) , [ConcatMap](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/transformation/ConcatMap.java) , [SwitchMap](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/transformation/SwitchMap.java) , [Buffer](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/transformation/Buffer.java)
过滤类型 | [Filter](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/Filter.java) , [OfType](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/OfType.java) , [Debounce](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/Debounce.java) , [ThrottleWithTimeout](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/ThrottleWithTimeout.java) , [Distinct](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/Distinct.java) , [DistinctUntilChanged](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/DistinctUntilChanged.java) , [First](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/First.java) , [Last](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/Last.java) , [Take](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/Take.java) , [Skip](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/Skip.java)
结合类型 | [Merge](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/combining/Merge.java)  , [Zip](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/combining/Zip.java) , [CombineLatest](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/combining/CombineLatest.java)
错误处理类型 | [Retry](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/errorhandling/Retry.java)  , [OnErrorResumeNext](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/errorhandling/OnErrorResumeNext.java)
辅助操作类型 | [Delay](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/utility/Delay.java) , [SubscribeOn](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/utility/SubscribeOn.java) , [Do](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/utility/Do.java) , [To](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/utility/To.java) , [Timeout](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/utility/Timeout.java)
条件和布尔类型 | [Amb](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/conditional/Amb.java) , [Contains](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/conditional/Contains.java) , [TakeUntil](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/conditional/TakeUntil.java) , [SkipUntil](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/conditional/SkipUntil.java)
算术和聚合类型 | [Reduce](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/mathematical/Reduce.java) , [Max](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/mathematical/Max.java) , [Min](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/mathematical/Min.java) , [Sum](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/mathematical/Sum.java)

## 特别感谢

* [RxDocs](https://github.com/mcxiaoke/RxDocs)
* [中文文档](https://www.kancloud.cn/luponu/rxjava_zh/974447)
* [RxJava Wiki](https://github.com/ReactiveX/rxjava/wiki)

## 如果觉得项目还不错，可以考虑打赏一波

> 你的打赏是我维护的动力，我将会列出所有打赏人员的清单在下方作为凭证，打赏前请留下打赏项目的备注！

![pay.png](https://ss.im5i.com/2021/06/14/6twG6.png)

## 联系方式

> 更多资讯内容，欢迎扫描关注我的个人微信公众号:【我的Android开源之旅】

![gzh_weixin.jpg](https://ss.im5i.com/2021/06/14/65yoL.jpg)
