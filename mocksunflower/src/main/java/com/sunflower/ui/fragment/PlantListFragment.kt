package com.sunflower.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunflower.data.PlantEntity
import com.sunflower.databinding.FragmentPlantListBinding
import com.sunflower.ui.adapter.PlantAdapter
import com.sunflower.utils.InjectorUtil
import com.sunflower.viewmodels.PlantListViewModel
import kotlinx.android.synthetic.main.fragment_plant_list.*

/**
 * A simple [Fragment] subclass.
 * 这里使用了 https://developer.android.google.cn/topic/libraries/data-binding/expressions
 * 中的
 * val listItemBinding = ListItemBinding.inflate(layoutInflater, viewGroup, false)
 * or
 * val listItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false)
 */
class PlantFragment : Fragment() {
    private lateinit var viewModel: PlantListViewModel
    private lateinit var adapter: PlantAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlantListBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root
        val factory = InjectorUtil.providePlantListViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(PlantListViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PlantAdapter()
        adapter.setItemClickListener(object : PlantAdapter.OnItemPlantClickListener {
            override fun onItemPlantClick(view: View, plantEntity: PlantEntity?) {
                val navDirections =
                    PlantFragmentDirections.actionPlantFragmentToPlantDetailFragment(plantEntity?.plantId ?: "")
                view.findNavController().navigate(navDirections)
            }
        })
        viewModel.getPlants()?.observe(viewLifecycleOwner, Observer { it ->
            it?.let {
                adapter.addAll(it)
            }
        })

        fragment_plant_list_rv.layoutManager = LinearLayoutManager(context)
        fragment_plant_list_rv.adapter = adapter

        fragment_plant_show_my_garden_btn.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }
}
