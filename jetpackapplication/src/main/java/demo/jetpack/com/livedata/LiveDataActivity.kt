package demo.jetpack.com.livedata

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import demo.jetpack.com.R
import demo.jetpack.com.livedata.map.TransformationMapActivity
import demo.jetpack.com.livedata.mediatorlivedata.MediatorLiveDataActivity
import demo.jetpack.com.livedata.mutablelivedata.MutableLiveDataActivity
import demo.jetpack.com.livedata.switchmap.TransformationSwitchMapActivity
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        btn_mutable_livedata.setOnClickListener {
            startActivity(Intent(this, MutableLiveDataActivity::class.java))
        }
        btn_mediator_livedata.setOnClickListener {
            startActivity(Intent(this, MediatorLiveDataActivity::class.java))
        }
        btn_transformation_map.setOnClickListener {
            startActivity(Intent(this, TransformationMapActivity::class.java))
        }
        btn_transformation_switchmap.setOnClickListener {
            startActivity(Intent(this, TransformationSwitchMapActivity::class.java))
        }
    }
}
