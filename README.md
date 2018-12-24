## DaggerDemo (app项目)
#### Done
* @Inject
> package inject
* @Module
* @Provides
* @Component
> package component
* @Qualtifier
> package qualtifier
>
> 1.@Named
>
> 2.@Qualifier
* Component的依赖关系
> package siblingscomponent
* SubComponent的两种实现方式
> package extendcomponentone
>
> 暴露接口
>
> package extendcomponenttwo
>
> 使用Builder
* @Scope
> package scopeone
>
> 生命周期内单例
>
> package scopetwo
>
> 全局单例
* @BindsInstance
> package bindinstance
* @Binds
> package binds
* Lazy
> package lazy
>
> 1.@Lazy
>
> 2.@Provider
* @IntoMap,@IntoSet
> package intomapintoset
* 全局AppComponent和AppModule的使用
> package global
>
> component之间采用了dependencies的方式
#### TODO
* Others
## DaggerAndroidDemo (daggerandroiddemo项目)
#### Done
* DaggerAndroid的使用
## JetPackDemo (jetpackapplication项目)
#### Done
* DataBinding
> 基本使用，ViewStub [binding]
>
> Observable Data [binding/observable]
>
> 自定义BindAdapter [binding/bindingadapter]
>
> include [binding/include]
>
> RecyclerView [binding/list]
>
> 双向绑定 [binding/twoway]
#### TODO
* JetPack的使用，例如Navigation，DataBinding，LiveData，ViewModel
* 实现使用Dagger框架的MVVM程序