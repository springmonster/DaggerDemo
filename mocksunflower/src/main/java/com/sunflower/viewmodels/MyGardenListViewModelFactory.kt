package com.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sunflower.data.MyGardenRepository

/**
 */
class MyGardenListViewModelFactory(private val myGardenRepository: MyGardenRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MyGardenListViewModel(myGardenRepository) as T
    }
}