package demo.jetpack.com.livedata.mediatorlivedata

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import demo.jetpack.com.R
import kotlinx.android.synthetic.main.fragment_mutable_live_data.*

class MediatorLiveDataFragment : Fragment() {

    private val changeObserver = Observer<String> { value ->
        value?.let {
            txt_fragment.text = it
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mediator_live_data, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val mediatorLiveData = MediatorLiveData<String>()
        mediatorLiveData.addSource((activity as MediatorLiveDataActivity).liveDataA) {
            mediatorLiveData.value = "A:$it"
        }
        mediatorLiveData.addSource((activity as MediatorLiveDataActivity).liveDataB) {
            mediatorLiveData.value = "B:$it"
        }
        // 这里谁最后添加显示谁的数据
        // 当 Fragment 恢复活动状态时，
        // 它就会收到 LiveDataB 的最新数据，
        // 无论 LiveDataB 变化的比 LiveDataA 变化的早或晚。
        // 从上面代码可以看到，这是因为 LiveDataB 是最后被添加到 MediatorLiveData 中的。
        mediatorLiveData.observe(this, changeObserver)
    }
}
