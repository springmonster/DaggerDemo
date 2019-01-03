package com.sunflower.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sunflower.data.MyGardenEntity

class MyGardenDiffCallback : DiffUtil.ItemCallback<MyGardenEntity>() {
    override fun areItemsTheSame(oldItem: MyGardenEntity, newItem: MyGardenEntity): Boolean {
        return oldItem.gardenPlantingId == newItem.gardenPlantingId
    }

    override fun areContentsTheSame(oldItem: MyGardenEntity, newItem: MyGardenEntity): Boolean {
        return oldItem.plantId == newItem.plantId
    }
}