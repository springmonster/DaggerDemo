package demo.dagger.com.daggerandroiddemo.ui

import demo.dagger.com.daggerandroiddemo.R
import demo.dagger.com.daggerandroiddemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initViews() {
        activity_main_btn.setOnClickListener {
            startActivity<SecondActivity>()
        }
    }

    override fun onResume() {
        super.onResume()

        activity_main_tv1.text = baseResources.getString(R.string.main_name)

        baseSharedPreferences.edit().putString("test", "test string").apply()

        activity_main_tv2.text = baseSharedPreferences.getString("test", "")
    }
}
