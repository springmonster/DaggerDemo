package demo.dagger.com.daggerdemo.component

class ComponentFatherBean(
    private var str: String?,
    private val componentSonBean: ComponentSonBean,
    private val componentSon1Bean: ComponentSon1Bean
) {

    override fun toString(): String {
        return "$componentSonBean,\n" +
                "$str,\n" +
                "$componentSon1Bean"
    }
}
