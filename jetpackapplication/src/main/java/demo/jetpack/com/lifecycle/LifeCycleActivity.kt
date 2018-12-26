package demo.jetpack.com.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import demo.jetpack.com.R

class LifeCycleActivity : AppCompatActivity() {
    lateinit var presenter: LifeCycleActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        presenter = LifeCycleActivityPresenter()
        lifecycle.addObserver(presenter)
    }

}
