package demo.dagger.com.daggerandroiddemo.di.componment

import dagger.Component
import dagger.android.AndroidInjectionModule
import demo.dagger.com.daggerandroiddemo.MyApp
import demo.dagger.com.daggerandroiddemo.di.module.AppModule
import demo.dagger.com.daggerandroiddemo.di.module.MainActivityModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AndroidInjectionModule::class, MainActivityModule::class])
interface AppComponent {
    fun inject(myApp: MyApp)
}