package com.sunflower.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
class PlantEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val plantId: String,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val wateringInterval: Int = 7,
    val imageUrl: String = ""
)