package com.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import com.sunflower.data.MyGardenRepository

class MyGardenListViewModel(
    private val myGardenRepository: MyGardenRepository
) : ViewModel()