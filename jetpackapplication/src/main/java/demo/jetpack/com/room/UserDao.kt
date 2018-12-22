package demo.jetpack.com.room

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM userTable")
    fun queryAllUsers(): List<UserEntity>

    @Query("SELECT * FROM userTable WHERE uid=:uid")
    fun queryUser(uid: Int): UserEntity

    @Insert
    fun insertUser(userEntity: UserEntity)

    @Update
    fun updateUser(userEntity: UserEntity)

    @Delete
    fun deleteUsers(vararg userEntity: UserEntity)
}