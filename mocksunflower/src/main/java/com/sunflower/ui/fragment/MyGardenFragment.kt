package com.sunflower.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunflower.R
import com.sunflower.databinding.FragmentMyGardenBinding
import com.sunflower.ui.adapter.MyGardenAdapter
import com.sunflower.utils.InjectorUtil
import com.sunflower.viewmodels.MyGardenListViewModel
import kotlinx.android.synthetic.main.fragment_my_garden.*

/**
 * A simple [Fragment] subclass.
 *
 */
class MyGardenFragment : Fragment() {
    private lateinit var adapter: MyGardenAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = context ?: requireActivity()

        val viewModel = ViewModelProviders.of(
            this,
            InjectorUtil.provideMyGardenListViewModelFactory(context)
        ).get(MyGardenListViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentMyGardenBinding>(
            inflater,
            R.layout.fragment_my_garden,
            container,
            false
        )

        adapter = MyGardenAdapter()
        viewModel.plantsInGarden.observe(this, Observer { plants ->
            binding.hasPlantings = (plants != null && plants.isNotEmpty())
            if (plants != null && plants.isNotEmpty()) {
                adapter.submitList(plants)
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_my_garden_rv.layoutManager = LinearLayoutManager(context)
        fragment_my_garden_rv.adapter = adapter

        fragment_my_garden_show_all_plant_btn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_myGardenFragment_to_plantFragment)
        }
    }
}
