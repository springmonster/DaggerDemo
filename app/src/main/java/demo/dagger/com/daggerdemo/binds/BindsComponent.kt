package demo.dagger.com.daggerdemo.binds

import dagger.BindsInstance
import dagger.Component

/**
 * @author Charles.Kuang
 */
@Component(modules = [BindsModule::class])
interface BindsComponent {
    fun inject(bindsActivity: BindsActivity)

    @Component.Builder
    interface Builder {
        fun build(): BindsComponent
        @BindsInstance
        fun buildName(name: String): Builder
    }
}