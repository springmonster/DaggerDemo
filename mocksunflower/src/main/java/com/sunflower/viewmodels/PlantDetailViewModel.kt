package com.sunflower.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sunflower.data.PlantEntity
import com.sunflower.data.PlantRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PlantDetailViewModel(
    private val plantRepository: PlantRepository,
    private val plantId: String
) : ViewModel() {

    val plantEntity: LiveData<PlantEntity>

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun addPlantToGarden() {
        viewModelScope.launch {

        }
    }

    init {
        plantEntity = plantRepository.getPlant(plantId)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}