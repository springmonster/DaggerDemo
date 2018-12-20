package demo.dagger.com.daggerdemo.scopetwo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_scope_two.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class ScopeTwoActivity : AppCompatActivity() {

    @Inject
    lateinit var scopeTwoBean: ScopeTwoBean

    @Inject
    lateinit var scopeTwoBean1: ScopeTwoBean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope_two)

        ScopeTwoComponentInit.getScopeTowComponent()?.inject(this)

        activity_scope_two_tv.text = with(StringBuilder()) {
            append(scopeTwoBean)
            append("\n")
            append(scopeTwoBean1)
            toString()
        }

        activity_scope_two_btn.setOnClickListener {
            startActivity<ScopeTwoAnotherActivity>()
        }
    }
}
