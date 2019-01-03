package demo.jetpack.com.binding.observable

import androidx.lifecycle.MutableLiveData

/**
 * @author Charles.Kuang
 */
data class BindingPerson(
    val text: MutableLiveData<String>,
    val text1: MutableLiveData<String>,
    val text2: MutableLiveData<String>,
    val text3: MutableLiveData<String>
)