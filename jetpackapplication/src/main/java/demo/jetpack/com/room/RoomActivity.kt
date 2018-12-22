package demo.jetpack.com.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import demo.jetpack.com.JetpackApplication
import demo.jetpack.com.R
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.coroutines.*

class RoomActivity : AppCompatActivity() {

    val job = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        activity_room_insert.setOnClickListener {
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
}
