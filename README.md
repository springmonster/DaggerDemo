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
## MockSunFlowerDemo (mocksunflowerdemo项目)
#### TODO
* 模仿Google的SunFlower项目
#### 目前的疑惑点
* ViewModel，LiveData，DataBinding的组合使用，生命周期？？？
* Transformations是什么？？？
* MediatorLiveData是什么？？？
* ListAdapter的使用，DiffUtil的使用？？？
* Room的联合查询，sunflower项目中有两个数据库表，通过plantId来作为foreignkey？？？
* Room的API细化，例如Converters？？？
* Coroutines的细化，比如sunflower项目中的数据库查询都是在UI线程，为什么？？？
(这个如果使用了LiveData包装查询出的数据，可以不必在IO线程去查询，猜测LiveData有切换线程的操作，需要继续调查)
* WorkManager的细化，用Coroutines可不可以，为什么？？？
* 如果使用Dagger Android，如何改造？？？
* Navigation的覆盖back按键事件？？？
* Navigation的跳转API有几种？？？
* 用了DataBinding之后可以在View的代码层级（不是xml）不去手写R.layout，这样有什么规律，优点缺点是什么？？？