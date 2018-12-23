package demo.jetpack.com.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idescout.sql.SqlScoutServer
import demo.jetpack.com.JetpackApplication
import demo.jetpack.com.R
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.coroutines.*

class RoomActivity : AppCompatActivity() {
    lateinit var sqlScoutServer: SqlScoutServer
    val job: Job? = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + job!!)
    val ioScope = CoroutineScope(Dispatchers.IO + job!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        sqlScoutServer = SqlScoutServer.create(this, packageName)

        activity_room_query.setOnClickListener {
            ioScope.launch {
                val lists = queryAllUsers()

                val sb: StringBuilder = StringBuilder()

                lists.forEach { UserEntity ->
                    sb.append(UserEntity.uid.toString() + UserEntity.firstName + UserEntity.lastName).append("\n")
                }
                withContext(Dispatchers.Main) {
                    activity_room_tv.text = ""
                    activity_room_tv.text = sb.toString()
                }
            }
        }

        activity_room_add.setOnClickListener {
            // Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
            // 这里不能在UI线程进行数据库的操作
            uiScope.launch {
                val lists = withContext(Dispatchers.IO) {
                    val userEntity = UserEntity(0, "张", "三")
                    insertUser(userEntity)
                    queryAllUsers()
                }

                val sb: StringBuilder = StringBuilder()

                lists.forEach {
                    sb.append(it.uid.toString() + it.firstName + it.lastName).append("\n")
                }
                activity_room_tv.text = ""
                activity_room_tv.text = sb.toString()
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

    private suspend fun queryAllUsers(): List<UserEntity> {
        return JetpackApplication
            .getUserDatabase()
            .userDao()
            .queryAllUsers()
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.let {
            it.cancel()
        }
    }
}
