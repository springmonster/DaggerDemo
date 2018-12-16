package demo.dagger.com.daggerandroiddemo.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import demo.dagger.com.daggerandroiddemo.MainActivity
import demo.dagger.com.daggerandroiddemo.di.scope.ActivityScope


@Module
abstract class MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [])
    abstract fun contributeMainActivityInjector(): MainActivity
}