package demo.jetpack.com

import android.app.Application
import androidx.room.Room
import demo.jetpack.com.room.simple.UserDatabase

class JetpackApplication : Application() {
    companion object {
        private lateinit var userDatabase: UserDatabase
        private lateinit var application: Application

        fun getUserDatabase(): UserDatabase {
            return userDatabase
        }

        fun getApplicaiton(): Application {
            return application
        }
    }

    override fun onCreate() {
        super.onCreate()

        application = this

        userDatabase = Room.databaseBuilder(
            this,
            UserDatabase::class.java,
            "user-database"
        ).build()
    }
}