package com.sunflower.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MyGardenDao {
    @Query("SELECT * FROM my_garden")
    fun getGardenPlantings(): LiveData<List<MyGardenEntity>>

    @Query("SELECT * FROM my_garden WHERE id = :gardenPlantingId")
    fun getGardenPlanting(gardenPlantingId: Long): LiveData<MyGardenEntity>

    @Query("SELECT * FROM my_garden WHERE plant_id = :plantId")
    fun getGardenPlantingForPlant(plantId: String): LiveData<MyGardenEntity>

    /**
     * This query will tell Room to query both the [Plant] and [GardenPlanting] tables and handle
     * the object mapping.
     */
//    @Transaction
//    @Query("SELECT * FROM plants")
//    fun getPlantAndGardenPlantings(): LiveData<List<PlantAndGardenPlantings>>

    @Insert
    fun insertGardenPlanting(gardenPlanting: MyGardenEntity): Long

    @Delete
    fun deleteGardenPlanting(gardenPlanting: MyGardenEntity)
}