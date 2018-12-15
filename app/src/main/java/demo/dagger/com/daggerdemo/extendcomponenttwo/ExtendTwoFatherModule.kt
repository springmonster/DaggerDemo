package demo.dagger.com.daggerdemo.extendcomponenttwo

import dagger.Module
import dagger.Provides

@Module(subcomponents = [ExtendTwoSonComponent::class])
class ExtendTwoFatherModule {
    @Provides
    fun provideKeyBoard(): Keyboard {
        return Keyboard()
    }
}