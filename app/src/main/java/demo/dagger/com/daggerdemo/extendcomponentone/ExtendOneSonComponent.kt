package demo.dagger.com.daggerdemo.extendcomponentone

import dagger.Subcomponent

@Subcomponent(modules = [ExtendOneSonModule::class])
interface ExtendOneSonComponent {
    fun inject(extendOneComponentActivity: ExtendOneComponentActivity)
}