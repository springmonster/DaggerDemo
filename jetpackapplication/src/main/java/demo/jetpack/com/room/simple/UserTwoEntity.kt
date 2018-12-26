package demo.jetpack.com.room.simple

import androidx.room.Entity

/**
 * 联合PrimaryKeys
 */
@Entity(primaryKeys = ["firstName", "lastName"])
data class UserTwoEntity(
    val firstName: String,
    val lastName: String
)