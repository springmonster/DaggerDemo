package com.sunflower.data

import androidx.room.*
import java.util.*

@Entity(
    tableName = "my_garden",
    foreignKeys = [ForeignKey(
        entity = PlantEntity::class, parentColumns = ["id"],
        childColumns = ["plant_id"]
    )],
    indices = [Index("plant_id")] // 这里是使用了索引
)
class MyGardenEntity(
    @ColumnInfo(name = "plant_id")
    val plantId: String,

    @ColumnInfo(name = "plant_date")
    val plantDate: Calendar = Calendar.getInstance(),

    @ColumnInfo(name = "last_watering_date")
    val lastWateringDate: Calendar = Calendar.getInstance()
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var gardenPlantingId: Long = 0
}