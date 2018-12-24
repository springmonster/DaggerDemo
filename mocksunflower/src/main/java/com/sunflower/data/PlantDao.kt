package com.sunflower.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlantDao {
    @Query("SELECT * FROM plants ORDER BY name")
    fun getAllPlants(): LiveData<List<PlantEntity>>

    @Query("SELECT * FROM plants WHERE growZoneNumber=:growZoneNumber ORDER BY name")
    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): LiveData<List<PlantEntity>>

    @Query("SELECT * FROM plants WHERE id = :plantId")
    fun getPlant(plantId: String): LiveData<PlantEntity>

    // 这里会进行替换
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPlants(plants: List<PlantEntity>)
}