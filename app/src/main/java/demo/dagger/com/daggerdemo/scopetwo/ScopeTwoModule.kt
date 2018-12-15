package demo.dagger.com.daggerdemo.scopetwo

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ScopeTwoModule {

    @Singleton
    @Provides
    fun provideScopeTwoBean(): ScopeTwoBean {
        return ScopeTwoBean()
    }
}