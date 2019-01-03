package demo.jetpack.com.binding.observable

import androidx.lifecycle.MutableLiveData

/**
 * @author Charles.Kuang
 */
class BindingListTestEntity {
    var list: MutableLiveData<List<String>>? = MutableLiveData()
}