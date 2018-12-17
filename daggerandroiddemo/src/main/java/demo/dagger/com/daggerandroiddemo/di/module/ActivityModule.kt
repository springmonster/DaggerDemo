package demo.dagger.com.daggerandroiddemo.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import demo.dagger.com.daggerandroiddemo.di.scope.ActivityScope
import demo.dagger.com.daggerandroiddemo.ui.MainActivity


@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivityInjector(): MainActivity
}