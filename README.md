# RxJava3Sample

RxJava3使用演示

## 发射器类型

类型	| 描述
|---|---
Observable<T> | 能够发射0或n个数据，并以成功或错误事件终止。
Flowable<T> | 能够发射0或n个数据，并以成功或错误事件终止。支持Backpressure，可以控制数据源发射的速度。可由Observable转化而来。
Single<T> | 只发射单个数据或错误事件。只处理 onNext 和 onError 事件，没有onComplete。
Completable | 它从来不发射数据，只处理 onComplete 和 onError 事件。可以看成是Rx的Runnable。
Maybe<T> | 能够发射0或者1个数据，要么成功，要么失败。类似Single和Completable的结合。如果处理了onNext 和 onError，那么就不处理onComplete。

## Subject

> Subject 既是 Observable 又是 Observer(Subscriber)

类型	| 描述
|---|---
PublishSubject | 只能接收到订阅之后的所有数据
BehaviorSubject | 接收到订阅前的最后一条数据和订阅后的所有数据
AsyncSubject | 只接收到最后一条数据
ReplaySubject | 接收订阅前和订阅后的所有数据
SerializedSubject | 线程安全的Subject，可由其他Subject调用toSerialized转换而来

## 常用操作符

类型	| 操作符
|---|---
创建类型 | [create](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/creation/Create.java) 、[just](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/creation/Just.java) 、[timer](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/creation/Timer.java) 、[interval](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/creation/Interval.java) 、[from](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/creation/From.java) 、[error](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/creation/Error.java)
转换类型 | [map](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/transformation/Map.java) 、[flatMap](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/transformation/FlatMap.java) 、[concatMap](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/transformation/ConcatMap.java) 、[switchMap](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/transformation/SwitchMap.java) 、[buffer](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/transformation/Buffer.java)
过滤类型 | [filter](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/Filter.java) 、[ofType](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/OfType.java) 、[debounce](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/Debounce.java) 、[throttleWithTimeout](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/ThrottleWithTimeout.java) 、[distinct](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/Distinct.java) 、[distinctUntilChanged](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/DistinctUntilChanged.java) 、[first](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/First.java) 、[last](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/Last.java) 、[take](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/Take.java) 、[skip](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/filtering/Skip.java)
结合类型 | [merge](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/combining/Merge.java)  、[zip](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/combining/Zip.java) 、[combineLatest](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/combining/CombineLatest.java)
错误处理类型 | [retry](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/errorhandling/Retry.java) 、[onErrorResumeNext](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/errorhandling/OnErrorResumeNext.java)
辅助操作类型 | [delay](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/utility/Delay.java) 、[subscribeOn](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/utility/SubscribeOn.java) 、[do](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/utility/Do.java) 、[to](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/utility/To.java) 、[timeout](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/utility/Timeout.java)
条件和布尔类型 | [amb](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/conditional/Amb.java) 、[contains](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/conditional/Contains.java) 、[takeUntil](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/conditional/TakeUntil.java) 、[skipUntil](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/conditional/SkipUntil.java)
算术和聚合类型 | [reduce](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/mathematical/Reduce.java) 、[max](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/mathematical/Max.java) 、[min](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/mathematical/Min.java) 、[sum](https://github.com/xuexiangjys/RxJava3Sample/blob/master/app/src/main/java/com/xuexiang/rxjava3sample/fragment/operators/mathematical/Sum.java)

## Scheduler

类型	| 描述
|---|---
Schedulers.io | 缓存线程池，线程数量无穷大，用于I/O操作
Schedulers.computation | 固定线程池，大小为CPU核数，用于CPU密集型计算（无阻塞）
Schedulers.single | 单线程池
Schedulers.newThread | 为指定任务启动一个新的线程
Schedulers.trampoline | 当其它排队的任务完成后，在当前线程排队开始执行
Schedulers.from | 使用指定的Executor作为调度器
AndroidSchedulers.mainThread | Android的主线程，即UI线程

## Plugins

> 插件，又可称Hook, 可以修改Rxjava的默认行为。

使用RxJavaPlugins可以进行以下三类功能的Hook和自定义：

* 发射器Observable、Single、Completable和Maybe的生命周期（装载和被订阅）。

* Rxjava的各类线程调度器Scheduler。

* Rxjava全局未处理的错误。

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
