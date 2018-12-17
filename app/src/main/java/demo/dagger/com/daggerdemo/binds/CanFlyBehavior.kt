package demo.dagger.com.daggerdemo.binds

import javax.inject.Inject

/**
 * @author Charles.Kuang
 */
class CanFlyBehavior @Inject constructor() : FlyBehavior {
    override fun fly(): String {
        return "会飞"
    }
}