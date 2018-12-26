package demo.jetpack.com

import android.app.Application
import androidx.room.Room
import demo.jetpack.com.room.simple.UserDatabase

class JetpackApplication : Application() {
    companion object {
        private lateinit var userDatabase: UserDatabase

        fun getUserDatabase(): UserDatabase {
            return userDatabase
        }
    }

    override fun onCreate() {
        super.onCreate()

        userDatabase = Room.databaseBuilder(
            this,
            UserDatabase::class.java,
            "user-database"
        ).build()
    }
}