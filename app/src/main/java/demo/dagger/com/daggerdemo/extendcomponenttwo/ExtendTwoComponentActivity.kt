package demo.dagger.com.daggerdemo.extendcomponenttwo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_extend_two_component.*
import javax.inject.Inject

class ExtendTwoComponentActivity : AppCompatActivity() {

    @Inject
    lateinit var keyboard: Keyboard
    @Inject
    lateinit var mouse: Mouse

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extend_two_component)

        val extendTwoFatherComponent = DaggerExtendTwoFatherComponent
            .builder()
            .extendTwoFatherModule(ExtendTwoFatherModule())
            .build()

        extendTwoFatherComponent
            .getExtendTwoSonComponent()
            .build()
            .inject(this)

        activity_extend_two_component_tv.text = "键盘是 $keyboard 鼠标是 $mouse"
    }
}
