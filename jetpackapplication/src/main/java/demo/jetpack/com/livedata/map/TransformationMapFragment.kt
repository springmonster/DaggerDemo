package demo.jetpack.com.livedata.map

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import demo.jetpack.com.R
import kotlinx.android.synthetic.main.fragment_mutable_live_data.*

class TransformationMapFragment : Fragment() {

    private val changeObserver = Observer<String> { value ->
        value?.let {
            txt_fragment.text = it
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_transformation_map, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val transformedLiveData = Transformations.map((activity as TransformationMapActivity).liveDataA) { it ->
            "A--->:$it"
        }
        transformedLiveData.observe(this, changeObserver)
    }
}
