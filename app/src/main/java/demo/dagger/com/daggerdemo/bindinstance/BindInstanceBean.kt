package demo.dagger.com.daggerdemo.bindinstance

import android.content.Context

class BindInstanceBean(val name: String, val context: Context) {
    fun showParams(): String {
        return "name is $name and context is $context"
    }
}