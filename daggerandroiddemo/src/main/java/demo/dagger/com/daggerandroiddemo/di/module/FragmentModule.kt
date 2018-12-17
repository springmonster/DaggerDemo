package demo.dagger.com.daggerandroiddemo.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import demo.dagger.com.daggerandroiddemo.di.scope.FragmentScope
import demo.dagger.com.daggerandroiddemo.ui.MainFragment


@Module
abstract class FragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeMainFragmentInjector(): MainFragment
}