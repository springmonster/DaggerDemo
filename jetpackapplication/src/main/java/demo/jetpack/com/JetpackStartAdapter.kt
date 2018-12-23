package demo.jetpack.com

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import demo.jetpack.com.databinding.ItemJetpackLayoutBinding

class JetpackStartAdapter(val context: Context) : RecyclerView.Adapter<JetpackStartAdapter.JetpackStartViewHolder>() {
    private lateinit var mutableList: MutableList<StartEntity>
    private var onJetpackStartItemClickListener: OnJetpackStartItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JetpackStartViewHolder {
        return JetpackStartViewHolder(
            DataBindingUtil.inflate<ItemJetpackLayoutBinding>(
                LayoutInflater.from(context),
                R.layout.item_jetpack_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = this.mutableList.size

    override fun onBindViewHolder(holder: JetpackStartViewHolder, position: Int) {
        holder.getItemJetpackLayoutBinding().startEntity = this.mutableList[position]
        holder.getItemJetpackLayoutBinding().root.setOnClickListener {
            onJetpackStartItemClickListener?.onItemClick(this.mutableList[position])
        }
        holder.getItemJetpackLayoutBinding().executePendingBindings()
    }

    fun addAll(mutableList: MutableList<StartEntity>) {
        this.mutableList = mutableList
    }

    fun setOnJetpackStartItemClickListener(onJetpackStartItemClickListener: OnJetpackStartItemClickListener) {
        this.onJetpackStartItemClickListener = onJetpackStartItemClickListener
    }

    class JetpackStartViewHolder : RecyclerView.ViewHolder {

        private lateinit var itemJetpackLayoutBinding: ItemJetpackLayoutBinding

        constructor(itemJetpackLayoutBinding: ItemJetpackLayoutBinding) : super(itemJetpackLayoutBinding.root) {
            this.itemJetpackLayoutBinding = itemJetpackLayoutBinding
        }

        fun getItemJetpackLayoutBinding() = itemJetpackLayoutBinding
    }

    interface OnJetpackStartItemClickListener {
        fun onItemClick(startEntity: StartEntity)
    }
}