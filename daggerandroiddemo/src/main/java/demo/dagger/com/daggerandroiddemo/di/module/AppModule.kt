package demo.dagger.com.daggerandroiddemo.di.module

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import demo.dagger.com.daggerandroiddemo.MyApp
import javax.inject.Singleton

@Module
class AppModule(val myApp: MyApp) {
    @Singleton
    @Provides
    fun provideMyApp(): MyApp {
        return myApp
    }

    @Singleton
    @Provides
    fun provideSharedPreference(): SharedPreferences {
        return myApp.getSharedPreferences(myApp.packageName, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideResources(): Resources {
        return myApp.resources
    }
}