package demo.dagger.com.daggerdemo.component

import dagger.Module
import dagger.Provides

@Module
class ComponentModule {

//    @Provides
//    fun provideComponentSon1Bean(): ComponentSon1Bean {
//        return ComponentSon1Bean("provide create son1")
//    }

    @Provides
    fun provideComponentSonBean(): ComponentSonBean {
        return ComponentSonBean("provide create son")
    }

    @Provides
    fun provideString(): String {
        return "provide create string"
    }

    /**
     * ComponentFatherBean依赖于String,ComponentSonBean,ComponentSon1Bean
     * String是Java提供的，不能在constructor里面添加@Inject注解，那就module提供
     * ComponentSonBean是第三方框架提供的，不能在constructor里面添加@Inject注解，那就module提供
     * ComponentSon1Bean是自己写的，可以在constructor里面添加@Inject注解，那就constructor添加@Inject注解
     */
//    @Provides
//    fun provideComponentBean(
//        str: String, componentSonBean: ComponentSonBean,
//        componentSon1Bean: ComponentSon1Bean
//    ): ComponentFatherBean {
//        return ComponentFatherBean(str, componentSonBean, componentSon1Bean)
////        return ComponentFatherBean(
////            "self create str",
////            ComponentSonBean("self create"),
////            ComponentSon1Bean("self create 1")
////        )
//    }

    @Provides
    fun provideComponentBean(
        str: String, componentSonBean: ComponentSonBean,
        componentSon1Bean: ComponentSon1Bean
    ): ComponentFatherBean {
        return ComponentFatherBean(str, componentSonBean, ComponentSon1Bean("son1"))
    }
}