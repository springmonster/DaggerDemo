package com.sunflower.data

/**
 * 这个是做什么的？是进行数据查询
 */
class PlantRepository private constructor(private val plantDao: PlantDao) {
    fun getPlants() = plantDao.getAllPlants()

    fun getPlant(plantId: String) = plantDao.getPlant(plantId)

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) =
        plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)

    companion object {
        @Volatile
        private var instance: PlantRepository? = null

        fun getInstance(plantDao: PlantDao): PlantRepository {
            return instance ?: synchronized(this) {
                instance ?: PlantRepository(plantDao)
            }.also {
                instance = it
            }
        }
    }
}