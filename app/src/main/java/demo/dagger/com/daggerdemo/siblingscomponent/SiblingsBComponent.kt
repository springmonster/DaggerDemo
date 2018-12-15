package demo.dagger.com.daggerdemo.siblingscomponent

import dagger.Component

@Component(dependencies = [SiblingsAComponent::class], modules = [SiblingsBModule::class])
interface SiblingsBComponent {
    fun inject(siblingsActivity: SiblingsActivity)
}