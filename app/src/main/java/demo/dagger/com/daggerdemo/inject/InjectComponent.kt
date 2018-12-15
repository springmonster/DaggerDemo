package demo.dagger.com.daggerdemo.inject

import dagger.Component

@Component
interface InjectComponent {
    fun inject(injectActivity: InjectActivity)
}