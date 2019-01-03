package com.sunflower.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.sunflower.R
import com.sunflower.databinding.FragmentPlantDetailBinding
import com.sunflower.utils.InjectorUtil
import com.sunflower.viewmodels.PlantDetailViewModel
import com.sunflower.viewmodels.PlantDetailViewModelFactory

/**
 * A simple [Fragment] subclass.
 *
 */
class PlantDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val plantId = PlantDetailFragmentArgs.fromBundle(arguments ?: Bundle()).plantId

        val factory: PlantDetailViewModelFactory =
            InjectorUtil.providePlantDetailViewModelFactory(requireContext(), plantId)

        val plantDetailViewModel = ViewModelProviders.of(this, factory).get(PlantDetailViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentPlantDetailBinding>(
            inflater,
            R.layout.fragment_plant_detail,
            container,
            false
        ).apply {
            viewModel = plantDetailViewModel
            setLifecycleOwner(this@PlantDetailFragment)
            fab.setOnClickListener { view ->
                plantDetailViewModel.addPlantToGarden()
                Snackbar.make(view, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

}
