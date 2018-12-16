package demo.dagger.com.daggerdemo.global

import dagger.Module
import dagger.Provides

@Module
class GlobalTestModule {

    @PerActivity
    @Provides
    fun provideStudent(): Student {
        return Student("张三", 18)
    }
}