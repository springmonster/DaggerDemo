package com.sunflower.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunflower.R
import com.sunflower.data.PlantEntity
import com.sunflower.databinding.ItemPlantLayoutBinding
import com.sunflower.ui.fragment.PlantListFragmentDirections

class PlantListAdapter : ListAdapter<PlantEntity, PlantListAdapter.PlantViewHolder>(PlantDiff()) {
    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.getBinding().plant = getItem(position)
        holder.getBinding().apply {
            root.setOnClickListener {
                val navDirections =
                    PlantListFragmentDirections.actionPlantFragmentToPlantDetailFragment(
                        getItem(position).plantId ?: ""
                    )
                it.findNavController().navigate(navDirections)
            }
        }
        holder.getBinding().executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantListAdapter.PlantViewHolder {
        return PlantListAdapter.PlantViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_plant_layout,
                parent,
                false
            )
        )
    }

    class PlantViewHolder(private val binding: ItemPlantLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun getBinding(): ItemPlantLayoutBinding {
            return binding
        }
    }

    class PlantDiff : DiffUtil.ItemCallback<PlantEntity>() {
        override fun areItemsTheSame(oldItem: PlantEntity, newItem: PlantEntity): Boolean {
            return oldItem.plantId == newItem.plantId
        }

        override fun areContentsTheSame(oldItem: PlantEntity, newItem: PlantEntity): Boolean {
            return oldItem == newItem
        }

    }
}