package demo.dagger.com.daggerandroiddemo.di.module

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import demo.dagger.com.daggerandroiddemo.di.componment.SecondActivityComponent
import demo.dagger.com.daggerandroiddemo.ui.SecondActivity

/**
 * @author Charles.Kuang
 */
@Module(subcomponents = [SecondActivityComponent::class])
abstract class SecondActivityModule {
    @Binds
    @IntoMap
    @ClassKey(SecondActivity::class)
    abstract fun bindSecondActivityInjectorFactory(builder: SecondActivityComponent.Builder): AndroidInjector.Factory<*>
}