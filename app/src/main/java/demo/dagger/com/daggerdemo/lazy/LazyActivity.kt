package demo.dagger.com.daggerdemo.lazy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.Lazy
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_lazy.*
import javax.inject.Inject
import javax.inject.Provider

class LazyActivity : AppCompatActivity() {
    @Inject
    lateinit var lazyBean1: Lazy<LazyBean>

    @Inject
    lateinit var provider1: Provider<LazyBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lazy)

        DaggerLazyNormalComponent.builder().build().inject(this)

        activity_lazy_btn.setOnClickListener {
            activity_lazy_tv.text = with(StringBuilder()) {
                append("Lazy : \n")
                append(lazyBean1.get())
                append("\n")
                append(lazyBean1.get())
                append("\n")
                append(lazyBean1.get())
                append("\n")
                append(lazyBean1.get())
                append("\n")
                append("Provider : \n")
                append(provider1.get())
                append("\n")
                append(provider1.get())
                append("\n")
                append(provider1.get())
                append("\n")
                append(provider1.get())
                toString()
            }
        }
    }
}
