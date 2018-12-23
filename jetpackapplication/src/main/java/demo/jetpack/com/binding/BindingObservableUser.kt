package demo.jetpack.com.binding

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

class BindingObservableUser {
    val firstName = ObservableField<String>()
    val lastName = ObservableField<String>()
    val age = ObservableInt()
}