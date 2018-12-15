package demo.dagger.com.daggerdemo.siblingscomponent

import dagger.Component

@Component(modules = [SiblingsAModule::class])
interface SiblingsAComponent {
    fun canProvideCar(): Car
}