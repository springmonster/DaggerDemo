package demo.jetpack.com.downloadmanager

import android.app.DownloadManager
import android.database.ContentObserver
import android.database.Cursor
import android.util.Log

/**
 * @author Charles.Kuang
 */
class DownloadObserver
    (
    private val downloadManager: DownloadManager,
    private val taskId: Long,
    private val downloadProgress: DownloadProgress
) :
    ContentObserver(null) {
    private val query: DownloadManager.Query = DownloadManager.Query().setFilterById(taskId)
    private var cursor: Cursor? = null
    private var lastProgressInt: Int = 0

    override fun onChange(selfChange: Boolean) {
        super.onChange(selfChange)
        try {
            cursor = downloadManager.query(query)
            if (cursor != null && cursor!!.moveToFirst()) {
                val curBytes = cursor!!
                    .getLong(cursor!!.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))
                val totalBytes = cursor!!
                    .getLong(cursor!!.getColumnIndexOrThrow(DownloadManager.COLUMN_TOTAL_SIZE_BYTES))
                val progressInt = (curBytes * 100 / totalBytes).toInt()
                if (totalBytes != 0L) {
                    if (lastProgressInt != progressInt) {
                        lastProgressInt = progressInt
                        downloadProgress.onProgressChanged(progressInt)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            cursor?.close()
        }
    }

    interface DownloadProgress {
        fun onProgressChanged(progressInt: Int)
    }
}
