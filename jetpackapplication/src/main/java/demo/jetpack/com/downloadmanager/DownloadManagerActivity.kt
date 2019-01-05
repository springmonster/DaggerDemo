package demo.jetpack.com.downloadmanager

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.tbruyelle.rxpermissions2.RxPermissions
import demo.jetpack.com.R
import demo.jetpack.com.databinding.ActivityDownloadManagerBinding
import kotlinx.android.synthetic.main.activity_download_manager.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton

/**
 * @author Charles.Kuang
 */
class DownloadManagerActivity : AppCompatActivity() {
    var progressInt = 0
    private lateinit var downloadProgressView: DownloadProgressBar
    private lateinit var rxPermissions: RxPermissions
    private lateinit var downloadReceiver: DownloadReceiver
    private lateinit var binding: ActivityDownloadManagerBinding

    companion object {
        private const val REQUEST_CODE_GET_IMAGE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_manager)

        rxPermissions = RxPermissions(this)

        val downloadViewModel = DownloadViewModel()
        binding = ActivityDownloadManagerBinding.inflate(layoutInflater)
        binding.vm = downloadViewModel
        binding.vm!!.isDownloadCompleted.observe(this, Observer {
            if (it) {
                download_progress_view.stopLoading()
                alert("Download file is /Download/hello.pdf", "Download") {
                    yesButton {}
                    noButton {}
                }.show()
            }
        })
        binding.vm!!.progressInt.observe(this, Observer {
            download_progress_view.setProgress(it)
        })

        download_btn_start.setOnClickListener {
            startDownload()
        }

        downloadReceiver = DownloadReceiver(downloadViewModel)
        downloadReceiver.register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        downloadReceiver.unregister(this)
    }

    @SuppressLint("CheckResult")
    fun startDownload() {
        rxPermissions
            .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .subscribe { granted ->
                if (granted) {
                    binding.vm!!.startDownload()
                } else {
                }
            }
    }
}
