package demo.dagger.com.daggerdemo.bindinstance

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(modules = [BindInstanceModule::class])
interface BindInstanceComponent {
    fun inject(bindInstanceActivity: BindInstanceActivity)

    @Component.Builder
    interface Builder {
        fun build(): BindInstanceComponent

        @BindsInstance
        fun provideStringInstance(name: String): Builder

        @BindsInstance
        fun provideContextInstance(context: Context): Builder
    }
}