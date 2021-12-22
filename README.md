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
