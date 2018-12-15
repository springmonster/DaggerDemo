package demo.dagger.com.daggerdemo.component

import javax.inject.Inject

class ComponentSon1Bean @Inject constructor(val name: String) {

    override fun toString(): String {
        return "Component son 1 bean name : $name"
    }
}
