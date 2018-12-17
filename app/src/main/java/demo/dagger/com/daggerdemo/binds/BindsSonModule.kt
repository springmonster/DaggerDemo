package demo.dagger.com.daggerdemo.binds

import dagger.Binds
import dagger.Module

/**
 * @author Charles.Kuang
 */
@Module
abstract class BindsSonModule {
    @Binds
    abstract fun provideFlyBehavior(canNotFlyBehavior: CanNotFlyBehavior): FlyBehavior
}