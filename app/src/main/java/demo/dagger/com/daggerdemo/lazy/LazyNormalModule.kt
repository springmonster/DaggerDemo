package demo.dagger.com.daggerdemo.lazy

import dagger.Module
import dagger.Provides

@Module
class LazyNormalModule {
    @Provides
//    @Singleton
    fun provideLazyBean(): LazyBean {
        return LazyBean()
    }
}