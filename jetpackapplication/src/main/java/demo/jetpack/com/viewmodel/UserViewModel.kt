package demo.jetpack.com.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    val user = MutableLiveData<User>()
}