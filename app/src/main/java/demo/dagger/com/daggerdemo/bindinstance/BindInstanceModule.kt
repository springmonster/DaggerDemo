package demo.dagger.com.daggerdemo.bindinstance

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class BindInstanceModule {
    @Provides
    fun provideBindInstanceBean(name: String, context: Context): BindInstanceBean {
        return BindInstanceBean(name, context)
    }
}