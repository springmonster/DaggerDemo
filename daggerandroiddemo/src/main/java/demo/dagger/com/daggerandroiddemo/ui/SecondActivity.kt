package demo.dagger.com.daggerandroiddemo.ui

import demo.dagger.com.daggerandroiddemo.R
import demo.dagger.com.daggerandroiddemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_second

    override fun initViews() {
        activity_second_tv.text = baseResources.getString(R.string.second_name)
    }
}
