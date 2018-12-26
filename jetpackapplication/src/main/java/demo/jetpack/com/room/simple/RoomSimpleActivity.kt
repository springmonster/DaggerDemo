package demo.jetpack.com.room.simple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.idescout.sql.SqlScoutServer
import demo.jetpack.com.JetpackApplication
import demo.jetpack.com.R
import kotlinx.android.synthetic.main.activity_simple_room.*
import kotlinx.coroutines.*

class RoomSimpleActivity : AppCompatActivity() {
    private val job: Job = Job()
    private val job1: Job = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + job)
    val ioScope = CoroutineScope(Dispatchers.IO + job1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_room)

        SqlScoutServer.create(this, packageName)

        activity_room_query.setOnClickListener {
            val lists = queryAllUsers().observe(this@RoomSimpleActivity, Observer { list ->
                val sb: StringBuilder = StringBuilder()
                list.forEach { UserEntity ->
                    sb.append(UserEntity.uid.toString() + UserEntity.firstName + UserEntity.lastName).append("\n")
                    activity_room_tv.text = ""
                    activity_room_tv.text = sb.toString()
                }
            })
        }

        activity_room_add.setOnClickListener {
            // Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
            // 这里不能在UI线程进行数据库的操作，插入
            uiScope.launch {
                withContext(Dispatchers.IO) {
                    val userEntity = UserEntity(
                        0,
                        activity_room_first_et.text.toString(),
                        activity_room_last_et.text.toString()
                    )
                    insertUser(userEntity)
                }
            }
        }
    }

    private suspend fun insertUser(userEntity: UserEntity) {
        withContext(Dispatchers.IO) {
            JetpackApplication
                .getUserDatabase()
                .userDao()
                .insertUser(userEntity)
        }
    }

    private fun queryAllUsers(): LiveData<List<UserEntity>> {
        return JetpackApplication
            .getUserDatabase()
            .userDao()
            .queryAllUsers()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.let {
            it.cancel()
        }
    }
}
