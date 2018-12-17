package demo.dagger.com.daggerandroiddemo.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideSharedPreference(application: Application): SharedPreferences {
        return application.applicationContext.getSharedPreferences(
            application.applicationContext.packageName,
            Context.MODE_PRIVATE
        )
    }

    @Singleton
    @Provides
    fun provideResources(application: Application): Resources {
        return application.applicationContext.resources
    }
}