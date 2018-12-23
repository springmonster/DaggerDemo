package demo.jetpack.com.binding.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import demo.jetpack.com.BR
import demo.jetpack.com.R
import demo.jetpack.com.databinding.ItemLayoutOnBinding

class BindingAdapter constructor() : RecyclerView.Adapter<BindingViewHolder>() {

    private lateinit var layoutInflater: LayoutInflater
    private var mOnItemClickListener: OnItemClickListener? = null
    private var mBindingAnimalEntityList: MutableList<BindingAnimalEntity> = mutableListOf()

    constructor(context: Context) : this() {
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        return BindingViewHolder(
            DataBindingUtil.inflate<ItemLayoutOnBinding>(
                layoutInflater,
                R.layout.item_layout_on,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mBindingAnimalEntityList.size
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val animalEntity = mBindingAnimalEntityList[position]
        holder.getBinding().setVariable(BR.bindingAnimalEntity, animalEntity)
        holder.getBinding().executePendingBindings()
        holder.getBinding().root.setOnClickListener {
            mOnItemClickListener?.onItemClick(animalEntity)
        }
    }

    fun addAll(mutableList: MutableList<BindingAnimalEntity>) {
        mBindingAnimalEntityList.addAll(mutableList)
        notifyDataSetChanged()
    }

    fun add(animalEntity: BindingAnimalEntity) {
        mBindingAnimalEntityList.add(animalEntity)
        notifyItemInserted(mBindingAnimalEntityList.size)
    }

    fun remove() {
        if (mBindingAnimalEntityList.size >= 1) {
            mBindingAnimalEntityList.removeAt(0)
            notifyItemRemoved(0)
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(bindingAnimalEntity: BindingAnimalEntity)
    }
}