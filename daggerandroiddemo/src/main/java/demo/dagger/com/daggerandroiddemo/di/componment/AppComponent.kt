package demo.dagger.com.daggerandroiddemo.di.componment

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import demo.dagger.com.daggerandroiddemo.MyApp
import demo.dagger.com.daggerandroiddemo.di.module.ActivityModule
import demo.dagger.com.daggerandroiddemo.di.module.AppModule
import demo.dagger.com.daggerandroiddemo.di.module.FragmentModule
import demo.dagger.com.daggerandroiddemo.di.module.SecondActivityModule
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [AppModule::class,
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        SecondActivityModule::class]
)
interface AppComponent {
    fun inject(myApp: MyApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}