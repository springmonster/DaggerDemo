package demo.jetpack.com.binding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import demo.jetpack.com.R
import demo.jetpack.com.databinding.ActivityBinding2Binding
import kotlinx.android.synthetic.main.activity_binding2.*

class Binding2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val ActivityBinding2Binding = ActivityBinding2Binding.inflate(layoutInflater)

        val activityBinding2Binding: ActivityBinding2Binding =
            DataBindingUtil.setContentView(this, R.layout.activity_binding2)

        val user2 = BindingObservableUser()
        user2.firstName.set("a")
        user2.lastName.set("a")
        user2.age.set(20)

        activityBinding2Binding.bindingObservableUser = user2

        activity_binding_2_btn.setOnClickListener {
            user2.age.set(user2.age.get() + 1)
        }
    }
}
