package com.sunflower.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sunflower.data.PlantEntity
import com.sunflower.data.PlantRepository

class PlantListViewModel(private val plantRepository: PlantRepository) : ViewModel() {
    private var plantList: LiveData<List<PlantEntity>>? = null

    init {
        plantList = plantRepository.getPlants()
    }

    fun getPlants() = plantList
}