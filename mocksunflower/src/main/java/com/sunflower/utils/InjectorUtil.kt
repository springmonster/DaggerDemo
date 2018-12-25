package com.sunflower.utils

import android.content.Context
import com.sunflower.data.AppDataBase
import com.sunflower.data.MyGardenRepository
import com.sunflower.data.PlantRepository
import com.sunflower.viewmodels.MyGardenListViewModelFactory
import com.sunflower.viewmodels.PlantDetailViewModelFactory
import com.sunflower.viewmodels.PlantListViewModelFactory

object InjectorUtil {
    private fun getPlantRepository(context: Context): PlantRepository {
        return PlantRepository.getInstance(AppDataBase.getInstance(context).plantDao())
    }

    private fun getMyGardenRepository(context: Context): MyGardenRepository {
        return MyGardenRepository.getInstance(
            AppDataBase.getInstance(context).myGardenDao()
        )
    }

    fun provideMyGardenListViewModelFactory(
        context: Context
    ): MyGardenListViewModelFactory {
        val repository = getMyGardenRepository(context)
        return MyGardenListViewModelFactory(repository)
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
        return PlantDetailViewModelFactory(
            getPlantRepository(context),
            getMyGardenRepository(context),
            plantId
        )
    }
}