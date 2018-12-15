package demo.dagger.com.daggerdemo.siblingscomponent

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_siblings.*
import javax.inject.Inject

class SiblingsActivity : AppCompatActivity() {
    @Inject
    lateinit var car: Car
    @Inject
    lateinit var house: House

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_siblings)

        val siblingsAComponent =
            DaggerSiblingsAComponent.builder().siblingsAModule(SiblingsAModule()).build()

        DaggerSiblingsBComponent
            .builder()
            .siblingsAComponent(siblingsAComponent)
            .build()
            .inject(this)

        activity_sibling_tv.text = "房子 : $house 车子 : $car"
    }
}
