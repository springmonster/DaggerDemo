package demo.dagger.com.daggerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import demo.dagger.com.daggerdemo.binds.BindsActivity
import demo.dagger.com.daggerdemo.component.ComponentActivity
import demo.dagger.com.daggerdemo.extendcomponentone.ExtendOneComponentActivity
import demo.dagger.com.daggerdemo.extendcomponenttwo.ExtendTwoComponentActivity
import demo.dagger.com.daggerdemo.global.GlobalTestActivity
import demo.dagger.com.daggerdemo.inject.InjectActivity
import demo.dagger.com.daggerdemo.intomapintoset.IntoMapIntoSetActivity
import demo.dagger.com.daggerdemo.lazy.LazyActivity
import demo.dagger.com.daggerdemo.qualtifier.QualifierActivity
import demo.dagger.com.daggerdemo.scopeone.ScopeOneActivity
import demo.dagger.com.daggerdemo.scopetwo.ScopeTwoActivity
import demo.dagger.com.daggerdemo.siblingscomponent.SiblingsActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity_main_inject_btn.setOnClickListener {
            startActivity<InjectActivity>()
        }

        activity_main_component_btn.setOnClickListener {
            startActivity<ComponentActivity>()
        }

        activity_main_qualifier_btn.setOnClickListener {
            startActivity<QualifierActivity>()
        }

        activity_main_siblings_btn.setOnClickListener {
            startActivity<SiblingsActivity>()
        }

        activity_main_extend_component_one_btn.setOnClickListener {
            startActivity<ExtendOneComponentActivity>()
        }

        activity_main_extend_component_two_btn.setOnClickListener {
            startActivity<ExtendTwoComponentActivity>()
        }

        activity_main_scope_one_btn.setOnClickListener {
            startActivity<ScopeOneActivity>()
        }

        activity_main_scope_two_btn.setOnClickListener {
            startActivity<ScopeTwoActivity>()
        }

        activity_main_lazy_btn.setOnClickListener {
            startActivity<LazyActivity>()
        }

        activity_main_global_btn.setOnClickListener {
            startActivity<GlobalTestActivity>()
        }

        activity_main_binds_btn.setOnClickListener {
            startActivity<BindsActivity>()
        }

        activity_main_into_map_into_set_btn.setOnClickListener {
            startActivity<IntoMapIntoSetActivity>()
        }
    }
}
