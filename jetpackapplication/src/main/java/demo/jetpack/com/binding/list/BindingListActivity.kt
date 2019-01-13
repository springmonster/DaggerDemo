package demo.jetpack.com.binding.list

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import demo.jetpack.com.R
import demo.jetpack.com.databinding.ActivityBindingListBinding
import org.jetbrains.anko.toast

class BindingListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBindingListBinding
    private lateinit var bindingAdapter: BindingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityBindingListBinding>(this, R.layout.activity_binding_list)
        binding.listPresenter = ListPresenter()

        initViews()
    }

    private fun initViews() {
        binding.activityBindingListAdd.setOnClickListener {

        }

        binding.activityBindingListRemove.setOnClickListener {

        }

        val mutableList = mutableListOf<BindingAnimalEntity>().apply {
            add(BindingAnimalEntity("Bird", "something", false))
            add(BindingAnimalEntity("Lion", "Meat", true))
            add(BindingAnimalEntity("Tiger", "Meat", true))
            add(BindingAnimalEntity("Goat", "Leaf", false))
        }

        binding.activityBindingListRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        bindingAdapter = BindingAdapter(this)
        binding.activityBindingListRv.adapter = bindingAdapter
        bindingAdapter.addAll(mutableList)
        bindingAdapter.setOnItemClickListener(object : BindingAdapter.OnItemClickListener {
            override fun onItemClick(bindingAnimalEntity: BindingAnimalEntity) {
                toast(bindingAnimalEntity.name)
            }
        })
    }

    inner class ListPresenter {
        fun onAddItem(view: View) {
            bindingAdapter.add(BindingAnimalEntity("Tiger", "Meat", true))
        }

        fun onRemoveItem(view: View) {
            bindingAdapter.remove()
        }
    }
}
