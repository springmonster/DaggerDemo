package demo.jetpack.com.binding.observable

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import demo.jetpack.com.R
import demo.jetpack.com.databinding.ActivityBindingObservableBinding
import kotlinx.android.synthetic.main.activity_binding_observable.*

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

        val text = MutableLiveData<String>()
        text.value = "hello world"

        val text1 = MutableLiveData<String>()
        text1.value = "hello world"

        val text2 = MutableLiveData<String>()
        text2.value = "hello world"

        val text3 = MutableLiveData<String>()
        text3.value = "hello world"

        binding.bindingPerson = BindingPerson(text, text1, text2, text3)

        binding.bindingPerson?.text?.observe(this, Observer {
        })

        activity_binding_btn.setOnClickListener {
            binding.bindingPerson?.text?.value = "hello world 1"
        }

        val stringList0 = mutableListOf<String>("a", "b", "c")
        val bindingListTestEntity = BindingListTestEntity()
        val liveData = bindingListTestEntity.list
        liveData?.value = stringList0

        binding.bindingListTestEntity = bindingListTestEntity

        val ob = ObservableArrayList<String>()
        ob.add("a")
        ob.add("b")
        ob.add("c")

        activity_binding_btn1.setOnClickListener {
            ob.add("d")
            ob.add("e")
            ob.add("f")
        }

        binding.bindingListTestEntity?.list?.observe(this, Observer {
            Log.d("khch", "observer list is " + binding.bindingListTestEntity?.list?.value.toString())
        })

        binding.list = ob

        binding.setLifecycleOwner(this)
    }
}
