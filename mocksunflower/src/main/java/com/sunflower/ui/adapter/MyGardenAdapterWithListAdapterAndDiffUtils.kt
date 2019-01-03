package com.sunflower.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunflower.data.MyGardenEntity
import com.sunflower.databinding.ItemMyGardenPlantLayoutBinding
import com.sunflower.ui.fragment.MyGardenFragmentDirections

class MyGardenAdapterWithListAdapterAndDiffUtils :
    ListAdapter<MyGardenEntity, MyGardenAdapterWithListAdapterAndDiffUtils.ViewHolder>(MyGardenDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMyGardenPlantLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { myGardenEntity ->
            with(holder) {
                itemView.tag = myGardenEntity
                bind(createOnClickListener(myGardenEntity.plantId), myGardenEntity)
            }
        }
    }

    private fun createOnClickListener(plantId: String): View.OnClickListener {
        return View.OnClickListener {
            val direction = MyGardenFragmentDirections.actionMyGardenFragmentToPlantDetailFragment(plantId)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(private val myGardenPlantLayoutBinding: ItemMyGardenPlantLayoutBinding) :
        RecyclerView.ViewHolder(myGardenPlantLayoutBinding.root) {

        fun bind(listener: View.OnClickListener, myGardenEntity: MyGardenEntity) {
            with(myGardenPlantLayoutBinding) {
                clickListener = listener
                garden = myGardenEntity
                executePendingBindings()
            }
        }
    }
}