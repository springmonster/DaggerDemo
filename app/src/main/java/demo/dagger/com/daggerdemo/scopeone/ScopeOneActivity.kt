package demo.dagger.com.daggerdemo.scopeone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import demo.dagger.com.daggerdemo.R
import kotlinx.android.synthetic.main.activity_scope_one.*
import javax.inject.Inject

class ScopeOneActivity : AppCompatActivity() {
    @Inject
    lateinit var scopeOneBean: ScopeOneBean

    @Inject
    lateinit var scopeOneBean1: ScopeOneBean

    @Inject
    lateinit var scopeOneSelfBean: ScopeOneSelfBean

    @Inject
    lateinit var scopeOneSelfBean1: ScopeOneSelfBean

    @Inject
    lateinit var scopeOneNoScopeBean: ScopeOneNoScopeBean

    @Inject
    lateinit var scopeOneNoScopeBean1: ScopeOneNoScopeBean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope_one)

        val scopeOneSelfComponent = DaggerScopeOneComponent.builder().build()

        scopeOneSelfComponent.provideScopeOneSelfComponent().build().inject(this)

        scopeOneSelfComponent.provideScopeOneNoScopeComponent().build()

        activity_scope_one_tv.text = with(StringBuilder()) {
            append("Singleton\n\n")
            append(scopeOneBean)
            append("\n")
            append(scopeOneBean1)
            append("\n")
            append(scopeOneSelfBean)
            append("\n")
            append(scopeOneSelfBean1)
            append("\n\n")
            append("Without Singleton\n\n")
            append(scopeOneNoScopeBean)
            append("\n")
            append(scopeOneNoScopeBean1)
            toString()
        }
    }
}
