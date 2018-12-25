package com.sunflower.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sunflower.data.MyGardenEntity
import com.sunflower.data.MyGardenRepository

class MyGardenListViewModel(
    private val myGardenRepository: MyGardenRepository
) : ViewModel() {
    val plantsInGarden: LiveData<List<MyGardenEntity>> = myGardenRepository.getGardenPlantings()
}