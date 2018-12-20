package demo.jetpack.com.binding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import demo.jetpack.com.R
import demo.jetpack.com.databinding.ActivityBindingBinding
import kotlinx.android.synthetic.main.activity_binding.*
import org.jetbrains.anko.startActivity

class BindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityBindingBinding: ActivityBindingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_binding)

        activityBindingBinding.user = User("小明", "123456", 20, true)

        activity_binding_btn.setOnClickListener {
            startActivity<Binding2Activity>()
        }
    }
}
