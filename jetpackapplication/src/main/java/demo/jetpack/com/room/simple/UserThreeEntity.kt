package demo.jetpack.com.room.simple

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.Ignore

/**
 * Ignore
 */
@Entity(tableName = "user_three_table", primaryKeys = ["firstName", "lastName"])
data class UserThreeEntity(
    val firstName: String,
    val lastName: String,
    val age: Int,
    @Ignore
    val picture: Bitmap
)