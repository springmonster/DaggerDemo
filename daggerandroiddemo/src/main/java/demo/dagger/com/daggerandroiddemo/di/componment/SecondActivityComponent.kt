package demo.dagger.com.daggerandroiddemo.di.componment

import dagger.Subcomponent
import dagger.android.AndroidInjector
import demo.dagger.com.daggerandroiddemo.ui.SecondActivity

/**
 * @author Charles.Kuang
 */
@Subcomponent(modules = [])
interface SecondActivityComponent : AndroidInjector<SecondActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SecondActivity>()
}