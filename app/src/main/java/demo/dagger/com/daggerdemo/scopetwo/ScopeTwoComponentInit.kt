package demo.dagger.com.daggerdemo.scopetwo

object ScopeTwoComponentInit {
    private var scopeTwoComponent: ScopeTwoComponent? = null

    fun getScopeTowComponent(): ScopeTwoComponent? {
        if (scopeTwoComponent == null) {
            scopeTwoComponent = DaggerScopeTwoComponent.builder().build()
        }
        return scopeTwoComponent
    }
}