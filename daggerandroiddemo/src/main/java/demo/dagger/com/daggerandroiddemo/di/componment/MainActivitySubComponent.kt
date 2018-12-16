package demo.dagger.com.daggerandroiddemo.di.componment

import dagger.Subcomponent
import dagger.android.AndroidInjector
import demo.dagger.com.daggerandroiddemo.MainActivity
import demo.dagger.com.daggerandroiddemo.di.module.MainActivityModule

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivitySubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}