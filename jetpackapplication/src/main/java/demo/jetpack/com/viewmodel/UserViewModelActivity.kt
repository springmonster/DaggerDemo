package demo.jetpack.com.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import demo.jetpack.com.R
import demo.jetpack.com.databinding.ActivityUserViewModelBinding
import kotlinx.android.synthetic.main.activity_user_view_model.*

class UserViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user_view_model)

//        val userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
//        userViewModel.user.observe(this, Observer {
//            activity_user_view_model_name_tv.text = it?.name
//        })
//
//        activity_user_view_model_btn.setOnClickListener {
//            val user = User("张三", 20, 1)
//            userViewModel.user.value = user
//        }

        val userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        val binding =
            DataBindingUtil.setContentView<ActivityUserViewModelBinding>(this, R.layout.activity_user_view_model)
        binding.userViewModel = userViewModel
        binding.setLifecycleOwner(this)

        activity_user_view_model_btn.setOnClickListener {
            userViewModel.user.value = User("张三", 20, 1)
        }
    }
}
