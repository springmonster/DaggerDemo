package demo.dagger.com.daggerandroiddemo

import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var myResources: Resources

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        toast(myResources.getString(R.string.app_name))
    }
}
