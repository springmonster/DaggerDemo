package demo.jetpack.com.downloadmanager

import android.app.DownloadManager
import android.content.Context
import android.content.Context.DOWNLOAD_SERVICE
import android.net.Uri
import android.os.Environment
import android.os.Handler
import android.os.Message

/**
 * @author Charles.Kuang
 */
class DownloadService {
    companion object {
        //        val url = "https://qd.myapp.com/myapp/qqteam/AndroidQQ/mobileqq_android.apk"
        val DOWNLOAD_TYPE = "application/vnd.android.package-archive"
    }

    fun startDownload(context: Context, handler: Handler, url: String) {
        if (url.isBlank()) {
            return
        }

        val downloadManager = context.applicationContext.getSystemService(DOWNLOAD_SERVICE) as DownloadManager

        val request = DownloadManager.Request(Uri.parse(url))

        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI)

        val dirType = Environment.DIRECTORY_DOWNLOADS + "/Sapp"

        ensureDirTypeExists(dirType)

        request.setDestinationInExternalPublicDir(dirType, "Sapp.apk")

        val id = downloadManager.enqueue(request)

        val message = Message()
        message.what = 1

        handler.sendMessage(message)

        val downloadObserver = DownloadObserver(handler, downloadManager, id)

        context.contentResolver.registerContentObserver(
            Uri.parse("content://downloads/"),
            true, downloadObserver
        )
    }

    fun isUrlEmpty(url: String?): Boolean {
        return url.isNullOrBlank()
    }

    private fun ensureDirTypeExists(dirType: String) {
        val file = Environment.getExternalStoragePublicDirectory(dirType)
        if (file == null) {
            throw IllegalStateException("Failed to get external storage public directory")
        } else if (file.exists()) {
            if (!file.isDirectory) {
                throw IllegalStateException(file.absolutePath + " already exists and is not a directory")
            }
        } else {
            if (!file.mkdirs()) {
                throw IllegalStateException("Unable to create directory: " + file.absolutePath)
            }
        }
    }
}