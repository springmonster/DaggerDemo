package com.sunflower.utils

import android.content.Context
import com.sunflower.data.AppDataBase
import com.sunflower.data.PlantRepository
import com.sunflower.viewmodels.PlantDetailViewModelFactory
import com.sunflower.viewmodels.PlantListViewModelFactory

object InjectorUtil {
    private fun getPlantRepository(context: Context): PlantRepository {
        return PlantRepository.getInstance(AppDataBase.getInstance(context).plantDao())
    }

    /**
     * 这里提供一个[PlantListViewModelFactory]
     */
    fun providePlantListViewModelFactory(context: Context): PlantListViewModelFactory {
        return PlantListViewModelFactory(getPlantRepository(context))
    }

    /**
     * 这里提供一个[PlantDetailViewModelFactory]
     */
    fun providePlantDetailViewModelFactory(context: Context, plantId: String): PlantDetailViewModelFactory {
        return PlantDetailViewModelFactory(getPlantRepository(context), plantId)
    }
}