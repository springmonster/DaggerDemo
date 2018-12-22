package demo.jetpack.com.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
class UserEntity(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    @ColumnInfo(name = "firstName") var firstName: String?,
    @ColumnInfo(name = "lastName") var lastName: String?
)