package demo.jetpack.com.downloadmanager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

/**
 * @author Charles.Kuang
 */
class DownloadViewModel : ViewModel(), DownloadReceiver.DownloadListener {
    private val ioScope = CoroutineScope(Dispatchers.IO + Job())
    val isDownloadCompleted: MutableLiveData<Boolean> = MutableLiveData()
    val progressInt: MutableLiveData<Int> = MutableLiveData()
    private val mDownloader: Downloader = Downloader(progressInt)
    private var mDownloadId: Long = -1L

    init {
        isDownloadCompleted.value = false
        progressInt.value = 0
    }

    fun startDownload() {
        ioScope.launch {
            delay(1000)
            val url =
                "https://github.com/mynane/PDF/raw/master/%E4%B8%83%E5%A4%A9%E5%AD%A6%E4%BC%9A%20Nodejs%20-%20v1.0.pdf"

            if (mDownloadId < 0) {
                mDownloadId = mDownloader.startDownload(url)
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
        mDownloader.unregisterContentObserver()
        super.onCleared()
    }
}