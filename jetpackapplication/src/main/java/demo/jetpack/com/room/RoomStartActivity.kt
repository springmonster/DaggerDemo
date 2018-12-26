package demo.jetpack.com.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idescout.sql.SqlScoutServer
import demo.jetpack.com.R
import demo.jetpack.com.room.simple.RoomSimpleActivity
import kotlinx.android.synthetic.main.activity_room_start.*
import org.jetbrains.anko.startActivity

class RoomStartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_start)

        SqlScoutServer.create(this, packageName)

        activity_room_simple_btn.setOnClickListener {
            startActivity<RoomSimpleActivity>()
        }
    }
}
