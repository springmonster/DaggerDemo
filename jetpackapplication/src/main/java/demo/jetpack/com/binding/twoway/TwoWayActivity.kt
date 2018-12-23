package demo.jetpack.com.binding.twoway

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import demo.jetpack.com.R
import demo.jetpack.com.databinding.ActivityTwoWayBinding

class TwoWayActivity : AppCompatActivity() {
    private lateinit var activityTwoWayBinding: ActivityTwoWayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_way)

        activityTwoWayBinding = DataBindingUtil.setContentView<ActivityTwoWayBinding>(this, R.layout.activity_two_way)
        val formModel = FormModel()
        formModel.name = "James"
        formModel.password = "123456"
        activityTwoWayBinding.formModel = formModel
    }
}
