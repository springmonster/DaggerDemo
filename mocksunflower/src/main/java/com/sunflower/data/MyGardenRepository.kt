package com.sunflower.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyGardenRepository private constructor(
    private val myGardenDao: MyGardenDao
) {
    suspend fun createGardenPlanting(plantId: String) {
        withContext(Dispatchers.IO) {
            myGardenDao.insertGardenPlanting(MyGardenEntity(plantId))
        }
    }

    fun getGardenPlantings() = myGardenDao.getGardenPlantings()

    fun getPlantingInGarden(plantId: String) = myGardenDao.getGardenPlantingForPlant(plantId)

    companion object {
        @Volatile
        private var instance: MyGardenRepository? = null

        fun getInstance(myGardenDao: MyGardenDao): MyGardenRepository {
            return instance ?: synchronized(this) {
                instance ?: MyGardenRepository(myGardenDao).also {
                    instance = it
                }
            }
        }
    }
}