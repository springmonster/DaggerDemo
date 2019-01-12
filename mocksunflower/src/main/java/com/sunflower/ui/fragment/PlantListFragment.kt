package com.sunflower.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunflower.databinding.FragmentPlantListBinding
import com.sunflower.ui.adapter.PlantListAdapter
import com.sunflower.utils.InjectorUtil
import com.sunflower.viewmodels.PlantListViewModel
import kotlinx.android.synthetic.main.fragment_plant_list.*

/**
 *
 */
class PlantListFragment : Fragment() {
    private lateinit var viewModel: PlantListViewModel
    private lateinit var mListAdapter: PlantListAdapter

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

        mListAdapter = PlantListAdapter()
        viewModel.getPlants()?.observe(viewLifecycleOwner, Observer { it ->
            it?.let {
                mListAdapter.submitList(it)
            }
        })

        fragment_plant_list_rv.layoutManager = LinearLayoutManager(context)
        fragment_plant_list_rv.adapter = mListAdapter

        fragment_plant_show_my_garden_btn.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }
}
