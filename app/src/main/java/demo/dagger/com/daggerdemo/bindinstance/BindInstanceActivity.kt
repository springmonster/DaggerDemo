package demo.dagger.com.daggerdemo.bindinstance

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_bind_instance.*
import javax.inject.Inject

class BindInstanceActivity : AppCompatActivity() {

    @Inject
    lateinit var bindInstanceBean: BindInstanceBean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bind_instance)

        DaggerBindInstanceComponent
            .builder()
            .provideContextInstance(this)
            .provideStringInstance("Hello BindInstance")
            .build()
            .inject(this)

        activity_bind_instance_tv.text = bindInstanceBean.showParams()
    }
}
