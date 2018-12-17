package demo.dagger.com.daggerdemo.binds

/**
 * @author Charles.Kuang
 */
class Animal(val name: String, val flyBehavior: FlyBehavior) {
    fun displayAnimal(): String {
        return "Animal $name ${flyBehavior.fly()}"
    }
}