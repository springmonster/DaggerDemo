package demo.jetpack.com.binding.bindingadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import demo.jetpack.com.R
import demo.jetpack.com.databinding.ActivityBindingAdapterBinding

class BindingAdapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityBindingAdapterBinding>(this, R.layout.activity_binding_adapter)
        // "http://i.imgur.com/DvpvklR.png"
        binding.imageEntity = ImageEntity("http://i.imgur.com/DvpvklR.png", R.mipmap.ic_launcher)
    }
}
