package demo.dagger.com.daggerdemo.scopeone

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [ScopeOneSelfComponent::class, ScopeOneNoScopeComponent::class])
class ScopeOneModule {
    @Provides
    @Singleton
    fun provideScopeOneBean(): ScopeOneBean {
        return ScopeOneBean("Scope one Bean")
    }
}