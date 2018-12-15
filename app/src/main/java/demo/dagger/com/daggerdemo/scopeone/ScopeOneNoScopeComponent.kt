package demo.dagger.com.daggerdemo.scopeone

import dagger.Subcomponent

@Subcomponent
interface ScopeOneNoScopeComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ScopeOneNoScopeComponent
    }
}