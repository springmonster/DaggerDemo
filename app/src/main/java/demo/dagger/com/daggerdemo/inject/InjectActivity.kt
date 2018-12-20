package demo.dagger.com.daggerdemo.inject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_inject.*
import javax.inject.Inject

class InjectActivity : AppCompatActivity() {
    @Inject
    lateinit var injectBean: InjectBean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inject)

        DaggerInjectComponent.create().inject(this)

        activity_inject_tv.text = injectBean.toString()
    }
}
