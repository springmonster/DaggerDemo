package demo.jetpack.com.binding.observable

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayMap
import demo.jetpack.com.R
import demo.jetpack.com.databinding.ActivityBindingObservableBinding

class BindingObservableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityBindingObservableBinding>(this, R.layout.activity_binding_observable)

        val map = ObservableArrayMap<String, String>()
        map["A"] = "1"

        val bindingEmployee = BindingEmployee(map)
        bindingEmployee.firstName = "张"
        bindingEmployee.lastName = "三"
        bindingEmployee.visible = false

        binding.bindingEmployee = bindingEmployee

        binding.activityBindingObservableEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                bindingEmployee.firstName = s.toString()
                bindingEmployee.visible = !bindingEmployee.visible
                bindingEmployee.map["A"] = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }
}
