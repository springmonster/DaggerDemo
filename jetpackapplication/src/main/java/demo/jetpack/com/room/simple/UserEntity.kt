package demo.jetpack.com.room.simple

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 修改表的名字
 * PrimaryKey自动增长
 * @ColumnInfo可以修改字段的名字
 *
 * https://developer.android.google.cn/reference/androidx/room/package-summary
 */
@Entity(tableName = "userTable")
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Int,

    @ColumnInfo(name = "firstName")
    var firstName: String?,

    @ColumnInfo(name = "lastName")
    var lastName: String?
)