package com.sunflower.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunflower.data.MyGardenRepository
import com.sunflower.data.PlantEntity
import com.sunflower.data.PlantRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PlantDetailViewModel(
    private val plantRepository: PlantRepository,
    private val myGardenRepository: MyGardenRepository,
    private val plantId: String
) : ViewModel() {
    var isPlanted: LiveData<Boolean>? = null
    val plantEntity: LiveData<PlantEntity>

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun addPlantToGarden() {
        viewModelScope.launch {
            myGardenRepository.createGardenPlanting(plantId)
        }
    }

    init {
        val plantInMyGarden = myGardenRepository.getPlantingInGarden(plantId)
        isPlanted = Transformations.map(plantInMyGarden) {
            it != null
        }
        plantEntity = plantRepository.getPlant(plantId)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}