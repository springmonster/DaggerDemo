package demo.jetpack.com.downloadmanager

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter

class DownloadReceiver() : BroadcastReceiver() {
    var mDownloadListener:DownloadListener? = null

    constructor(downloadListener: DownloadListener?) : this() {
        mDownloadListener = downloadListener
    }

    override fun onReceive(context: Context, intent: Intent) {
        val downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
        mDownloadListener?.downloadComplete(downloadId)
    }

    fun register(context: Context) {
        val downloadFilter = IntentFilter()
        downloadFilter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        context.registerReceiver(this, downloadFilter)
    }

    fun unregister(context: Context) {
        context.unregisterReceiver(this)
    }

    interface DownloadListener {
        fun downloadComplete(downloadId: Long)
    }
}
