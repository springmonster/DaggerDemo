package demo.dagger.com.daggerdemo.intomapintoset

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_into_map_into_set.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class IntoMapIntoSetActivity : AppCompatActivity() {
    @Inject
    lateinit var mySet: Set<String>

    @Inject
    lateinit var myMap: Map<String, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_into_map_into_set)

        DaggerIntoMapIntoSetComponent.builder().build().inject(this)

        activity_into_tv1.text = mySet.toString()
        activity_into_tv2.text = myMap.toString()

        myMap["AA"]?.let { toast(it) }
    }
}
