package demo.dagger.com.daggerdemo.binds

import dagger.Module
import dagger.Provides

/**
 * @author Charles.Kuang
 */
@Module(includes = [BindsSonModule::class])
class BindsModule {
    @Provides
    fun provide(name: String, flyBehavior: FlyBehavior): Animal {
        return Animal(name, flyBehavior)
    }
}