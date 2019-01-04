package demo.jetpack.com.downloadmanager

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import demo.jetpack.com.R
import kotlinx.android.synthetic.main.activity_download_manager.*


class DownloadManagerActivity : AppCompatActivity() {
    var progressInt = 0
    var myHandler: MyHandler = MyHandler()
    lateinit var downloadProgressView: DownloadProgressBar
    lateinit var rxPermissions: RxPermissions

    companion object {
        private const val REQUEST_CODE_GET_IMAGE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_manager)

        rxPermissions = RxPermissions(this)

        downloadProgressView = findViewById(R.id.dpv3)

        download_btn_start.setOnClickListener {
            startDownload()
        }

        download_btn_end.setOnClickListener {
            myHandler.sendMessage(Message.obtain(myHandler, 3))
        }
    }

    @SuppressLint("CheckResult")
    fun startDownload() {
        rxPermissions
            .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .subscribe { granted ->
                if (granted) { // Always true pre-M
                    // I can control the camera now
                    DownloadService().startDownload(
                        this@DownloadManagerActivity as Context,
                        myHandler,
                        "https://s3.cn-north-1.amazonaws.com.cn/smt-repo/PRO/2.4.0/Android/smt-pro-apk-2.4.0-41305.apk"
                    )
                } else {
                    // Oups permission denied
                }
            }
    }

    inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                1 -> {
                    downloadProgressView.startLoading()
                }
                2 -> {
                    val progressInt = msg.data.getInt(DownloadObserver.PROGRESS)
                    downloadProgressView.setProgress(progressInt)

                    if (progressInt >= 100) {
                        val msg = Message()
                        msg.what = 3
                        myHandler.sendMessage(msg)
                    }
                }
                3 -> {
                    progressInt = 0
                    downloadProgressView.stopLoading()
                }
            }
//                2 -> {
//                    progressInt += 10
//
//                    if (progressInt > 100) {
//                        val msg = Message()
//                        msg.what = 3
//                        myHandler.sendMessage(msg)
//                    } else {
//                        val msg = Message()
//                        msg.what = 2
//                        myHandler.sendMessageDelayed(msg, 300)
//                        \\downloadProgressView.setProgress(progressInt)
//                    }
//                }
//                3 -> {
//                    progressInt = 0
//                    downloadProgressView.stopLoading()
//                }
//            }
        }
    }
}
