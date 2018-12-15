package demo.dagger.com.daggerdemo.scopeone

import dagger.Module
import dagger.Provides

@Module
class ScopeOneSelfModule {
    @Provides
    @SelfScope
    fun provideScopeSelfBean(): ScopeOneSelfBean {
        return ScopeOneSelfBean()
    }
}