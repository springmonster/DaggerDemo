package demo.dagger.com.daggerdemo.scopeone

import dagger.Subcomponent

@SelfScope
@Subcomponent(modules = [ScopeOneSelfModule::class])
interface ScopeOneSelfComponent {
    fun inject(scopeOneActivity: ScopeOneActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ScopeOneSelfComponent
    }
}