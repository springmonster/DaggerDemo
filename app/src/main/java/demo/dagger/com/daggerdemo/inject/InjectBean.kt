package demo.dagger.com.daggerdemo.inject

import javax.inject.Inject

class InjectBean @Inject constructor() {
    override fun toString(): String {
        return "this is simple InjectBean"
    }
}