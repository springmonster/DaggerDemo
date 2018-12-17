package demo.dagger.com.daggerdemo.binds

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_binds.*
import javax.inject.Inject

class BindsActivity : AppCompatActivity() {
    @Inject
    lateinit var animal: Animal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binds)

        DaggerBindsComponent.builder().buildName("老虎").build().inject(this)

        activity_binds_tv.text = animal.displayAnimal()
    }
}
