package demo.dagger.com.daggerdemo.scopetwo

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ScopeTwoModule::class])
interface ScopeTwoComponent {
    fun inject(scopeTwoActivity: ScopeTwoActivity)
    fun inject(scopeTwoAnotherActivity: ScopeTwoAnotherActivity)
}