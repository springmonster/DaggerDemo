package demo.dagger.com.daggerdemo.extendcomponentone

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_extend_component_one.*
import javax.inject.Inject

class ExtendComponentOneActivity : AppCompatActivity() {

    @Inject
    lateinit var cloth: Cloth
    @Inject
    lateinit var shoe: Shoe

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extend_component_one)

        val extendOneSonComponent = DaggerExtendOneFatherComponent
            .builder()
            .extendOneFatherModule(ExtendOneFatherModule())
            .build()
            .hasExtendOneSonComponent()

        extendOneSonComponent.inject(this)

        activity_extend_one_component_tv.text = "衣服是 $cloth 鞋子是 $shoe"
    }
}
