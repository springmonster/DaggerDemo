package demo.dagger.com.daggerdemo.scopetwo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_scope_two_another.*
import javax.inject.Inject

class ScopeTwoAnotherActivity : AppCompatActivity() {

    @Inject
    lateinit var scopeTwoBean: ScopeTwoBean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope_two_another)

        ScopeTwoComponentInit.getScopeTowComponent()?.inject(this)

        activity_scope_another_tv.text = with(scopeTwoBean) {
            toString()
        }
    }
}
