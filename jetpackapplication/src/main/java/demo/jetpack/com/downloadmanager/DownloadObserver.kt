package demo.jetpack.com.downloadmanager

import android.app.DownloadManager
import android.database.ContentObserver
import android.database.Cursor
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log

/**
 * Creates a content observer.
 *
 * @param handler The handler to run [.onChange] on, or null if none.
 */
class DownloadObserver
    (
    private val mHandler: Handler,
    private val mDownloadManager: DownloadManager,
    private val mTaskId: Long
) :
    ContentObserver(mHandler) {
    private val bundle = Bundle()
    private var message: Message? = null
    private val query: DownloadManager.Query = DownloadManager.Query().setFilterById(mTaskId)
    private var cursor: Cursor? = null

    override fun onChange(selfChange: Boolean) {
        super.onChange(selfChange)
        try {
            cursor = mDownloadManager.query(query)
            if (cursor == null) {
                return
            }
            cursor!!.moveToFirst()
            val curBytes = cursor!!
                .getLong(cursor!!.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))
            val totalBytes = cursor!!
                .getLong(cursor!!.getColumnIndexOrThrow(DownloadManager.COLUMN_TOTAL_SIZE_BYTES))
            val mProgress = (curBytes * 100 / totalBytes).toInt()
            if (totalBytes != 0L) {
                Log.d("Download", "curBytes==$curBytes")
                Log.d("Download", "totalBytes==$totalBytes")
                Log.d("Download", "mProgress------->$mProgress")
                message = mHandler.obtainMessage()
                message!!.what = 2
                bundle.putLong(CURBYTES, curBytes)
                bundle.putLong(TOTALBYTES, totalBytes)
                bundle.putInt(PROGRESS, mProgress)
                message!!.data = bundle
                mHandler.sendMessage(message)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (cursor != null) {
                cursor!!.close()
            }
        }
    }

    companion object {

        val CURBYTES = "curBytes"
        val TOTALBYTES = "totalBytes"
        val PROGRESS = "progress"
    }
}
