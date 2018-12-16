package demo.dagger.com.daggerdemo.global

import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_global_test.*
import javax.inject.Inject

class GlobalTestActivity : AppCompatActivity() {
    @Inject
    lateinit var student: Student
    @Inject
    lateinit var myResources: Resources
    @Inject
    lateinit var mySharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global_test)

        DaggerGlobalTestComponent
            .builder()
            .appComponent(MyApp.getAppComponent())
//            .globalTestModule(GlobalTestModule())
            .build()
            .inject(this)

        activity_global_test_btn.setOnClickListener {
            // 这里如果要获取一个资源
            val value = myResources.getString(R.string.global_test)
            activity_global_test_tv1.text = value

            // 这里要使用SharedPreferences
            mySharedPreferences.edit().putString("Student", student.name).commit()
            val studentName = mySharedPreferences.getString("Student", "")
            activity_global_test_tv2.text = studentName
        }
    }
}
