package demo.jetpack.com.downloadmanager

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import demo.jetpack.com.R


class DownloadManagerActivity : AppCompatActivity() {
    var progressInt = 0

    companion object {
        private const val REQUEST_CODE_GET_IMAGE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_manager)


        val downloadProgressView = findViewById<DownloadProgressBar>(R.id.dpv3)
        val successBtn = findViewById<Button>(R.id.success_text_btn)
        successBtn.setOnClickListener {
            progressInt += 10
            downloadProgressView.setProgress(progressInt)
        }

        downloadProgressView.setOnClickListener {
            downloadProgressView.playManualProgressAnimation()
        }
    }
}
