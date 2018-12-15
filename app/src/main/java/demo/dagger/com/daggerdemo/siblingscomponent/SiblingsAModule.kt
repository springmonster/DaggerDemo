package demo.dagger.com.daggerdemo.siblingscomponent

import dagger.Module
import dagger.Provides

@Module
class SiblingsAModule {
    @Provides
    fun provideCar(): Car {
        return Car()
    }
}