package com.sunflower.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sunflower.R
import com.sunflower.data.MyGardenEntity
import com.sunflower.databinding.ItemMyGardenPlantLayoutBinding

class MyGardenAdapter : RecyclerView.Adapter<MyGardenAdapter.PlantViewHolder>() {
    private var onItemPlantClickListener: OnItemPlantClickListener? = null
    private var plantList: List<MyGardenEntity>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        return PlantViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_my_garden_plant_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return this.plantList?.size ?: 0
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.getBinding().garden = plantList?.get(position)
        holder.getBinding().root.setOnClickListener {
            this.onItemPlantClickListener?.onItemPlantClick(it, plantList?.get(position))
        }
        holder.getBinding().executePendingBindings()
    }

    fun addAll(plantList: List<MyGardenEntity>) {
        this.plantList = plantList
        notifyDataSetChanged()
    }

    fun setItemClickListener(onItemPlantClickListener: OnItemPlantClickListener) {
        this.onItemPlantClickListener = onItemPlantClickListener
    }

    class PlantViewHolder(private val binding: ItemMyGardenPlantLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun getBinding(): ItemMyGardenPlantLayoutBinding {
            return binding
        }
    }

    interface OnItemPlantClickListener {
        fun onItemPlantClick(view: View, myGardenEntity: MyGardenEntity?)
    }
}