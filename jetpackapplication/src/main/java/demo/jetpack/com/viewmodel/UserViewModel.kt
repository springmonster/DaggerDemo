package demo.jetpack.com.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    val userVMEntity = MutableLiveData<UserVMEntity>()
}