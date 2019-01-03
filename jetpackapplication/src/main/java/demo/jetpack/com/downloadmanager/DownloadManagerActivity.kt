package demo.jetpack.com.downloadmanager

import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import demo.jetpack.com.R
import demo.jetpack.com.R.id.download_btn_end
import demo.jetpack.com.R.id.download_btn_start
import kotlinx.android.synthetic.main.activity_download_manager.*


class DownloadManagerActivity : AppCompatActivity() {
    var progressInt = 0
    var myHandler: MyHandler = MyHandler()
    lateinit var downloadProgressView: DownloadProgressBar

    companion object {
        private const val REQUEST_CODE_GET_IMAGE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_manager)

        downloadProgressView = findViewById(R.id.dpv3)

        download_btn_start.setOnClickListener {
            val msg = Message()
            msg.what = 1
            myHandler.sendMessage(msg)
        }

        download_btn_end.setOnClickListener {
            myHandler.sendMessage(Message.obtain(myHandler, 3))
        }
    }

    inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                1 -> {
                    downloadProgressView.startLoading()
                    val msg = Message()
                    msg.what = 2
                    myHandler.sendMessage(msg)
                }
                2 -> {
                    progressInt += 10

                    if (progressInt > 100) {
                        val msg = Message()
                        msg.what = 3
                        myHandler.sendMessage(msg)
                    } else {
                        val msg = Message()
                        msg.what = 2
                        myHandler.sendMessageDelayed(msg, 300)
                        downloadProgressView.setProgress(progressInt)
                    }
                }
                3 -> {
                    progressInt = 0
                    downloadProgressView.stopLoading()
                }
            }
        }
    }
}
