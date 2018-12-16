package demo.dagger.com.daggerdemo.extendcomponentone

import dagger.Component

@Component(modules = [ExtendOneFatherModule::class])
interface ExtendOneFatherComponent {
    fun hasExtendOneSonComponent(extendExtendOneSonModule: ExtendOneSonModule): ExtendOneSonComponent
}