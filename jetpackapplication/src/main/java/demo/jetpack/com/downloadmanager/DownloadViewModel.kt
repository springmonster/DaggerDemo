package demo.jetpack.com.downloadmanager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class DownloadViewModel : ViewModel(), DownloadReceiver.DownloadListener {
    private val ioScope = CoroutineScope(Dispatchers.IO + Job())
    val isDownloadCompleted: MutableLiveData<Boolean> = MutableLiveData()
    val progressInt: MutableLiveData<Int> = MutableLiveData()
    private val downloadService: DownloadService = DownloadService(progressInt)
    private var mDownloadId: Long = -1L

    init {
        isDownloadCompleted.value = false
        progressInt.value = 0
    }

    fun startDownload() {
        var url = ""
        ioScope.launch {
            delay(1000)
            url =
                    "https://github.com/mynane/PDF/raw/master/%E4%B8%83%E5%A4%A9%E5%AD%A6%E4%BC%9A%20Nodejs%20-%20v1.0.pdf"

            if (mDownloadId < 0) {
                mDownloadId = downloadService.startDownload(url)
            }
        }
    }

    override fun downloadComplete(downloadId: Long) {
        if (mDownloadId != -1L && mDownloadId == downloadId) {
            isDownloadCompleted.postValue(true)
            mDownloadId = -1L
        }
    }

    override fun onCleared() {
        downloadService.unregisterContentObserver()
        super.onCleared()
    }
}