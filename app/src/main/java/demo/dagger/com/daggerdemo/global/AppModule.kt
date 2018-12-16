package demo.dagger.com.daggerdemo.global

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val myApp: MyApp) {

    @Singleton
    @Provides
    fun provideApplication(): MyApp {
        return myApp
    }

    @Singleton
    @Provides
    fun provideSharedPreference(): SharedPreferences {
        return myApp.getSharedPreferences(myApp.applicationContext.packageName, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideResources(): Resources {
        return myApp.resources
    }
}