package demo.jetpack.com.room.simple

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class, UserTwoEntity::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}