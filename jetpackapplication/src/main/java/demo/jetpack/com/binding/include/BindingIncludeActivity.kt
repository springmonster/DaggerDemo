package demo.jetpack.com.binding.include

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import demo.jetpack.com.R
import demo.jetpack.com.binding.BindingUser
import demo.jetpack.com.databinding.ActivityBindingIncludeBinding

class BindingIncludeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityBindingIncludeBinding>(this, R.layout.activity_binding_include)
        binding.bindingUser = BindingUser("james", "123456", 30, false)
    }
}
