package demo.dagger.com.daggerdemo.extendcomponentone

import dagger.Module
import dagger.Provides

@Module
class ExtendOneFatherModule {
    @Provides
    fun provideCloth(): Cloth {
        return Cloth()
    }
}