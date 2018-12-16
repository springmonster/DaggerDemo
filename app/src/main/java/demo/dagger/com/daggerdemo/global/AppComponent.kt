package demo.dagger.com.daggerdemo.global

import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun sharedPreference(): SharedPreferences
    fun myApp(): MyApp
    fun resource(): Resources
}