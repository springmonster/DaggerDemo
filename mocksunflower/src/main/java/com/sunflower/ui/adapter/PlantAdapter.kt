package com.sunflower.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sunflower.R
import com.sunflower.data.PlantEntity
import com.sunflower.databinding.ItemPlantLayoutBinding

class PlantAdapter : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {
    private var onItemPlantClickListener: OnItemPlantClickListener? = null
    private var plantList: List<PlantEntity>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        return PlantViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_plant_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return this.plantList?.size ?: 0
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.getBinding().plant = plantList?.get(position)
        holder.getBinding().root.setOnClickListener {
            this.onItemPlantClickListener?.onItemPlantClick(it, plantList?.get(position))
        }
        holder.getBinding().executePendingBindings()
    }

    fun addAll(plantList: List<PlantEntity>) {
        this.plantList = plantList
        notifyDataSetChanged()
    }

    fun setItemClickListener(onItemPlantClickListener: OnItemPlantClickListener) {
        this.onItemPlantClickListener = onItemPlantClickListener
    }

    class PlantViewHolder(private val binding: ItemPlantLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun getBinding(): ItemPlantLayoutBinding {
            return binding
        }
    }

    interface OnItemPlantClickListener {
        fun onItemPlantClick(view: View, plantEntity: PlantEntity?)
    }
}