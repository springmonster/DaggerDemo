package demo.dagger.com.daggerdemo.binds

import javax.inject.Inject

/**
 * @author Charles.Kuang
 */
class CanNotFlyBehavior @Inject constructor() : FlyBehavior {
    override fun fly(): String {
        return "不会飞"
    }
}