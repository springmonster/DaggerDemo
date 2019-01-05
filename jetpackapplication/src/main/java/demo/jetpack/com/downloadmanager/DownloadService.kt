package demo.jetpack.com.downloadmanager

import android.app.DownloadManager
import android.content.Context.DOWNLOAD_SERVICE
import android.database.ContentObserver
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import androidx.lifecycle.MutableLiveData
import demo.jetpack.com.JetpackApplication

/**
 * @author Charles.Kuang
 */
class DownloadService(private val mProgressInt: MutableLiveData<Int>) : ContentObserver(null) {
    companion object {
        private val DOWNLOAD_DIRECTORY = Environment.DIRECTORY_DOWNLOADS + "/Sapp"
        private const val DOWNLOAD_URI = "content://downloads/"
    }

    private lateinit var mDownloadManager: DownloadManager
    private lateinit var mQuery: DownloadManager.Query
    private var lastProgressInt: Int = 0

    fun startDownload(url: String): Long {
        if (url.isBlank()) {
            return -1
        }

        if (!ensureDirectoryExist(DOWNLOAD_DIRECTORY)) {
            return -1
        }

        val request = DownloadManager.Request(Uri.parse(url))
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN)
        request.setDestinationInExternalPublicDir(DOWNLOAD_DIRECTORY, "hello.pdf")

        mDownloadManager = JetpackApplication.getApplicaiton().getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        val downloadId = mDownloadManager.enqueue(request)

        mQuery = DownloadManager.Query().setFilterById(downloadId)

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

    fun registerContentObserver() {
        JetpackApplication.getApplicaiton().contentResolver.registerContentObserver(
            Uri.parse(DOWNLOAD_URI),
            true,
            this
        )
    }

    fun unregisterContentObserver() {
        JetpackApplication.getApplicaiton().contentResolver.unregisterContentObserver(this)
    }

    override fun onChange(selfChange: Boolean) {
        super.onChange(selfChange)
        var cursor: Cursor? = null
        try {
            if (!this@DownloadService::mDownloadManager.isInitialized
                || !this@DownloadService::mQuery.isInitialized
            ) {
                return
            }
            cursor = mDownloadManager.query(mQuery)
            if (cursor != null && cursor.moveToFirst()) {
                val curBytes = cursor
                    .getLong(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))
                val totalBytes = cursor
                    .getLong(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_TOTAL_SIZE_BYTES))
                val progressInt = (curBytes * 100 / totalBytes).toInt()
                if (totalBytes != 0L) {
                    if (lastProgressInt != progressInt) {
                        lastProgressInt = progressInt
                        mProgressInt.postValue(lastProgressInt)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            cursor?.close()
        }
    }
}