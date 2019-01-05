package demo.jetpack.com.downloadmanager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

/**
 * @author Charles.Kuang
 */
class DownloadViewModel : ViewModel() {
    private val ioScope = CoroutineScope(Dispatchers.IO + Job())
    val progressInt: MutableLiveData<Int> = MutableLiveData()
    private val mDownloadService: DownloadService = DownloadService(progressInt)
    private var mDownloadId: Long = -1L

    init {
        progressInt.value = 0
        mDownloadService.registerContentObserver()
    }

    fun startDownload() {
        ioScope.launch {
//            val url = "https://github.com/mynane/PDF/raw/master/%E4%B8%83%E5%A4%A9%E5%AD%A6%E4%BC%9A%20Nodejs%20-%20v1.0.pdf"
            val url = "https://qd.myapp.com/myapp/qqteam/AndroidQQ/mobileqq_android.apk"

            if (mDownloadId < 0) {
                mDownloadId = mDownloadService.startDownload(url)
            }
        }
    }

    override fun onCleared() {
        mDownloadService.unregisterContentObserver()
        super.onCleared()
    }
}