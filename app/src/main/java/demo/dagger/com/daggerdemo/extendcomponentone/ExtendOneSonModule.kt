package demo.dagger.com.daggerdemo.extendcomponentone

import dagger.Module
import dagger.Provides

@Module
class ExtendOneSonModule {
    @Provides
    fun provideShoe(): Shoe {
        return Shoe()
    }
}