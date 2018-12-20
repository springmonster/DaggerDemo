package demo.jetpack.com.binding

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import demo.jetpack.com.R
import demo.jetpack.com.databinding.BindingThree

class Binding3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_binding3)
        val binding: BindingThree = DataBindingUtil.setContentView(this, R.layout.activity_binding3)
    }
}