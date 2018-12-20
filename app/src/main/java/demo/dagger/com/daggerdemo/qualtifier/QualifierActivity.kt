package demo.dagger.com.daggerdemo.qualtifier

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_qualifier.*
import javax.inject.Inject

class QualifierActivity : AppCompatActivity() {

    // 这里如果直接写@Named("chinese")，java中可以正常编译，但是Kotlin编译失败
    // 问题描述和解决方案
    // https://www.jianshu.com/p/1b98d0a0e42d
    // @field:Named("chinese")
    @Inject
    @field:RussianQ
    lateinit var countryLanguage: CountryLanguage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qualifier)

        DaggerCountryLanguageComponent.builder().countryLanguageModule(CountryLanguageModule()).build().inject(this)

        activity_qualifier_tv.text = countryLanguage.speak()
    }
}
