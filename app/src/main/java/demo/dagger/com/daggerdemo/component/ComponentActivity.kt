package demo.dagger.com.daggerdemo.component

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_component.*
import javax.inject.Inject

class ComponentActivity : AppCompatActivity() {

    @Inject
    lateinit var componentFatherBean: ComponentFatherBean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_component)

        DaggerComponentComponent.builder().componentModule(ComponentModule()).build().inject(this)

        component_activity_tv.text = componentFatherBean.toString()
    }
}
