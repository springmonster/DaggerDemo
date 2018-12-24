package demo.jetpack.com.binding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import demo.jetpack.com.R
import demo.jetpack.com.binding.bindingadapter.BindingAdapterActivity
import demo.jetpack.com.binding.include.BindingIncludeActivity
import demo.jetpack.com.binding.list.BindingListActivity
import demo.jetpack.com.binding.observable.BindingObservableActivity
import demo.jetpack.com.binding.twoway.TwoWayActivity
import demo.jetpack.com.databinding.ActivityBindingSimpleBinding
import kotlinx.android.synthetic.main.activity_binding_simple.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class BindingSimpleActivity : AppCompatActivity() {
    lateinit var binding: ActivityBindingSimpleBinding
    var bindingUser = BindingUser("小明", "123456", 20, true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_simple)

        binding.bindingUser = bindingUser
        binding.presenter = Presenter()
        binding.activityBindingVs.viewStub!!.inflate()

        activity_binding_include_btn.setOnClickListener {
            startActivity<BindingIncludeActivity>()
        }

        activity_binding_observable_btn.setOnClickListener {
            startActivity<BindingObservableActivity>()
        }

        activity_binding_list_btn.setOnClickListener {
            startActivity<BindingListActivity>()
        }

        activity_binding_two_way_btn.setOnClickListener {
            startActivity<TwoWayActivity>()
        }

        activity_binding_adapter_btn.setOnClickListener {
            startActivity<BindingAdapterActivity>()
        }
    }

    inner class Presenter {
        fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            bindingUser.name = s.toString()
            binding.bindingUser = bindingUser
        }

        fun onClick(view: View) {
            toast("This is binding toast")
        }

        fun onClickListenerBinding(bindingUser: BindingUser) {
            toast(bindingUser.name)
        }
    }
}
