package demo.jetpack.com

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import demo.jetpack.com.R.id.activity_jetpack_start_rv
import demo.jetpack.com.binding.BindingSimpleActivity
import demo.jetpack.com.databinding.ActivityJetpackStartBinding
import demo.jetpack.com.downloadmanager.DownloadManagerActivity
import demo.jetpack.com.lifecycle.LifeCycleActivity
import demo.jetpack.com.livedata.LiveDataActivity
import demo.jetpack.com.navigation.MainActivity
import demo.jetpack.com.room.RoomStartActivity
import demo.jetpack.com.viewmodel.UserViewModelActivity
import kotlinx.android.synthetic.main.activity_jetpack_start.*

class JetpackStartActivity : AppCompatActivity() {
    private lateinit var activityJetpackStartBinding: ActivityJetpackStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack_start)

        DataBindingUtil.setContentView<ActivityJetpackStartBinding>(this, R.layout.activity_jetpack_start)

        val mutableList = mutableListOf(
            StartEntity("DataBinding", BindingSimpleActivity::class.java),
            StartEntity("Navigation", MainActivity::class.java),
            StartEntity("Room", RoomStartActivity::class.java),
            StartEntity("ViewModel", UserViewModelActivity::class.java),
            StartEntity("LifeCycle", LifeCycleActivity::class.java),
            StartEntity("LiveData", LiveDataActivity::class.java),
            StartEntity("DownloadManager", DownloadManagerActivity::class.java)
        )
        val jetpackStartAdapter = JetpackStartAdapter(this)
        jetpackStartAdapter.addAll(mutableList)
        jetpackStartAdapter.setOnJetpackStartItemClickListener(object :
            JetpackStartAdapter.OnJetpackStartItemClickListener {
            override fun onItemClick(startEntity: StartEntity) {
                startActivity(Intent(this@JetpackStartActivity, startEntity.clazz))
            }
        })
        activity_jetpack_start_rv.layoutManager = LinearLayoutManager(this)
        activity_jetpack_start_rv.adapter = jetpackStartAdapter
    }
}
