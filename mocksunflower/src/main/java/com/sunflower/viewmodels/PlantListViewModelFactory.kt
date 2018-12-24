package com.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sunflower.data.PlantRepository

/**
 * 这里是为了给[PlantListViewModel]进行传参
 */
class PlantListViewModelFactory(private val plantRepository: PlantRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlantListViewModel(plantRepository) as T
    }
}