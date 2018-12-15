package demo.dagger.com.daggerdemo.siblingscomponent

import dagger.Module
import dagger.Provides

@Module
class SiblingsBModule {
    @Provides
    fun provideHouse(): House {
        return House()
    }
}