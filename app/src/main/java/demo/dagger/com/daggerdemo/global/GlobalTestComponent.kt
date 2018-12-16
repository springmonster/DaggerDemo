package demo.dagger.com.daggerdemo.global

import dagger.Component

@PerActivity
@Component(modules = [GlobalTestModule::class], dependencies = [AppComponent::class])
interface GlobalTestComponent {
    fun inject(globalTestActivity: GlobalTestActivity)
}