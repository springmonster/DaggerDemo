package demo.dagger.com.daggerdemo.intomapintoset

import dagger.Component

/**
 * @author Charles.Kuang
 */
@Component(modules = [IntoMapIntoSetModule::class])
interface IntoMapIntoSetComponent {
    fun inject(intoMapIntoSetActivity: IntoMapIntoSetActivity)
}