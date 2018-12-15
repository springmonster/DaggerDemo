package demo.dagger.com.daggerdemo.extendcomponenttwo

import dagger.Module
import dagger.Provides

@Module
class ExtendTwoSonModule {
    @Provides
    fun provideMouse(): Mouse {
        return Mouse()
    }
}