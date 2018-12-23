package demo.jetpack.com.binding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import demo.jetpack.com.R
import demo.jetpack.com.databinding.ActivityBindingBinding
import kotlinx.android.synthetic.main.activity_binding.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class BindingActivity : AppCompatActivity() {
    lateinit var activityBindingBinding: ActivityBindingBinding
    var bindingUser = BindingUser("小明", "123456", 20, true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_binding)

        activityBindingBinding.bindingUser = bindingUser
        activityBindingBinding.person = Person("领袖", 99)
        activityBindingBinding.presenter = Presenter()

        activity_binding_btn.setOnClickListener {
            startActivity<Binding2Activity>()
        }
    }

    inner class Presenter {
        fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            bindingUser.name = s.toString()
            activityBindingBinding.bindingUser = bindingUser
        }

        fun onClick(view: View) {
            toast("This is binding toast")
        }

        fun onClickListenerBinding(bindingUser: BindingUser) {
            toast(bindingUser.name)
        }
    }
}
