package demo.jetpack.com.binding

import android.databinding.ObservableField
import android.databinding.ObservableInt

class User2 {
    val firstName = ObservableField<String>()
    val lastName = ObservableField<String>()
    val age = ObservableInt()
}