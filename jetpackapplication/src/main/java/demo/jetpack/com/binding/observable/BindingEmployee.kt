package demo.jetpack.com.binding.observable

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableArrayMap
import demo.jetpack.com.BR

class BindingEmployee(val map: ObservableArrayMap<String, String>) : BaseObservable() {

    @get:Bindable
    var firstName = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }

    @get:Bindable
    var lastName = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }

    @get:Bindable
    var visible: Boolean = false
        set(value) {
            field = value
            notifyChange()
        }
}