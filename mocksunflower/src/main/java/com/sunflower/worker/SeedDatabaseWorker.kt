package com.sunflower.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.sunflower.data.AppDataBase
import com.sunflower.data.PlantEntity

class SeedDatabaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    companion object {
        private const val PLANT_DATA_FILENAME: String = "plants.json"
    }

    override fun doWork(): Result {
        val plantType = object : TypeToken<List<PlantEntity>>() {}.type
        var jsonReader: JsonReader? = null

        return try {
            val inputStream = applicationContext.assets.open(PLANT_DATA_FILENAME)
            jsonReader = JsonReader(inputStream.reader())
            val plantList: List<PlantEntity> = Gson().fromJson(jsonReader, plantType)
            val database = AppDataBase.getInstance(applicationContext)
            database.plantDao().insertAllPlants(plantList)
            Result.success()
        } catch (ex: Exception) {
            Result.failure()
        } finally {
            jsonReader?.close()
        }
    }
}