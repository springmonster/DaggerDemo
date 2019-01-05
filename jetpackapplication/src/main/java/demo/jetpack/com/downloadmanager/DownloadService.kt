package demo.jetpack.com.downloadmanager

import android.app.DownloadManager
import android.content.Context.DOWNLOAD_SERVICE
import android.net.Uri
import android.os.Environment
import androidx.lifecycle.MutableLiveData
import demo.jetpack.com.JetpackApplication

/**
 * @author Charles.Kuang
 */
class DownloadService(private val mProgressInt: MutableLiveData<Int>) {
    companion object {
        val DOWNLOAD_DIRECTORY = Environment.DIRECTORY_DOWNLOADS + "/Sapp"
    }

    lateinit var downloadObserver: DownloadObserver

    fun startDownload(url: String): Long {
        if (url.isBlank()) {
            return -1
        }

        if (!ensureDirectoryExist(DOWNLOAD_DIRECTORY)) {
            return -1
        }

        val request = DownloadManager.Request(Uri.parse(url))

//        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN)

        request.setDestinationInExternalPublicDir(DOWNLOAD_DIRECTORY, "hello.pdf")

        val downloadManager = JetpackApplication.getApplicaiton().getSystemService(DOWNLOAD_SERVICE) as DownloadManager

        val downloadId = downloadManager.enqueue(request)

        downloadObserver = DownloadObserver(
            downloadManager,
            downloadId,
            object : DownloadObserver.DownloadProgress {
                override fun onProgressChanged(progressInt: Int) {
                    mProgressInt.postValue(progressInt)
                }
            })

        JetpackApplication.getApplicaiton().contentResolver.registerContentObserver(
            Uri.parse("content://downloads/"),
            true, downloadObserver
        )

        return downloadId
    }

    private fun ensureDirectoryExist(dirType: String): Boolean {
        val file = Environment.getExternalStoragePublicDirectory(dirType)
        return when {
            file == null -> false
            file.exists() -> file.isDirectory
            else -> file.mkdirs()
        }
    }

    fun unregisterContentObserver() {
        JetpackApplication.getApplicaiton().contentResolver.unregisterContentObserver(downloadObserver)
    }
}