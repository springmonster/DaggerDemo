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
    private lateinit var mDownloadProgressView: DownloadProgressView
    private lateinit var rxPermissions: RxPermissions
    private lateinit var binding: ActivityDownloadManagerBinding
    private lateinit var viewModel:DownloadViewModel

    companion object {
        private const val REQUEST_CODE_GET_IMAGE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_manager)

        rxPermissions = RxPermissions(this)

        binding = ActivityDownloadManagerBinding.inflate(layoutInflater)
        binding.vm = DownloadViewModel()
        viewModel = binding.vm as DownloadViewModel
        viewModel.progressInt.observe(this, Observer {
            download_progress_view.setProgress(it)
            if (it == 100) {
                download_progress_view.stopLoading()
                alert("Download file is /Download/hello.pdf", "Download") {
                    yesButton {}
                    noButton {}
                }.show()
            }
        })

        download_btn_start.setOnClickListener {
            startDownload()
        }
    }

    @SuppressLint("CheckResult")
    fun startDownload() {
        rxPermissions
            .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .subscribe { granted ->
                if (granted) {
                    viewModel.startDownload()
                } else {
                }
            }
    }
}
