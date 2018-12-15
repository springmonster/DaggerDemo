package demo.dagger.com.daggerdemo.component

import dagger.Component

@Component(modules = [ComponentModule::class])
interface ComponentComponent {
    fun inject(componentActivity: ComponentActivity)
}