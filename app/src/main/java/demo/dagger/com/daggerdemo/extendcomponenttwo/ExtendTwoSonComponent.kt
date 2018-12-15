package demo.dagger.com.daggerdemo.extendcomponenttwo

import dagger.Subcomponent

@Subcomponent(modules = [ExtendTwoSonModule::class])
interface ExtendTwoSonComponent {
    fun inject(extendTwoComponentActivity: ExtendTwoComponentActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ExtendTwoSonComponent
    }
}