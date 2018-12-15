package demo.dagger.com.daggerdemo.extendcomponenttwo

import dagger.Component

@Component(modules = [ExtendTwoFatherModule::class])
interface ExtendTwoFatherComponent {
    fun getExtendTwoSonComponent(): ExtendTwoSonComponent.Builder
}