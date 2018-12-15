package demo.dagger.com.daggerdemo.qualtifier

import dagger.Component

@Component(modules = [CountryLanguageModule::class])
interface CountryLanguageComponent {
    fun inject(qualifierActivity: QualifierActivity)
}