package demo.dagger.com.daggerdemo.scopeone

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ScopeOneModule::class])
interface ScopeOneComponent {
    fun provideScopeOneSelfComponent(): ScopeOneSelfComponent.Builder
    fun provideScopeOneNoScopeComponent(): ScopeOneNoScopeComponent.Builder
}