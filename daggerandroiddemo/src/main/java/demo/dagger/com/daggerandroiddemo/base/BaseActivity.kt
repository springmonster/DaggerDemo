package demo.dagger.com.daggerandroiddemo.base

import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var baseResources: Resources

    @Inject
    lateinit var baseSharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initViews()
    }

    abstract fun getLayoutId(): Int

    abstract fun initViews()
}