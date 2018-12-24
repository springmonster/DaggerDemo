package com.sunflower.worker

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.sunflower.data.AppDataBase
import com.sunflower.data.PlantEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.InputStream

class InitDatabaseWorker {
    companion object {
        private const val PLANT_DATA_FILENAME: String = "plants.json"
    }

    fun initDatabaseInBackground(context: Context) {
        val job = Job()
        val ioScope = CoroutineScope(Dispatchers.IO + job)
        ioScope.launch {
            initDatabase(context)
        }
    }

    private fun initDatabase(context: Context) {
        val plantType = object : TypeToken<List<PlantEntity>>() {}.type
        var inputStream: InputStream? = null
        var jsonReader: JsonReader? = null
        try {
            inputStream = context.applicationContext.assets.open(PLANT_DATA_FILENAME)
            jsonReader = JsonReader(inputStream.reader())
            val plantList: List<PlantEntity> = Gson().fromJson(jsonReader, plantType)
            val database = AppDataBase.getInstance(context)
            database.plantDao().insertAllPlants(plantList)
        } catch (ex: Exception) {
            Log.e("database", ex.toString())
        } finally {
            inputStream?.close()
            jsonReader?.close()
        }
    }
}