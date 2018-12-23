package demo.jetpack.com.binding.list

import androidx.recyclerview.widget.RecyclerView
import demo.jetpack.com.databinding.ItemLayoutOnBinding

class BindingViewHolder : RecyclerView.ViewHolder {
    private lateinit var itemLayoutOnBinding: ItemLayoutOnBinding

    constructor(itemLayoutOnBinding: ItemLayoutOnBinding) : super(itemLayoutOnBinding.root) {
        this.itemLayoutOnBinding = itemLayoutOnBinding
    }

    fun getBinding() = itemLayoutOnBinding
}