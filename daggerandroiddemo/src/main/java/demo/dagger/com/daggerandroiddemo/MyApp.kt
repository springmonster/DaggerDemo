package demo.dagger.com.daggerandroiddemo

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import demo.dagger.com.daggerandroiddemo.di.componment.DaggerAppComponent
import demo.dagger.com.daggerandroiddemo.di.module.AppModule
import javax.inject.Inject


class MyApp : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)
    }
}