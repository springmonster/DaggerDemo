package demo.dagger.com.daggerdemo.lazy

import dagger.Component

//@Singleton
@Component(modules = [LazyNormalModule::class])
interface LazyNormalComponent {
    fun inject(lazyActivity: LazyActivity)
}