package demo.jetpack.com.binding.twoway

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import demo.jetpack.com.BR

class FormModel : BaseObservable() {
    @get:Bindable
    var name: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var password: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.password)
        }
}