package demo.dagger.com.daggerdemo.qualtifier

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class CountryLanguageModule {

    @Named("chinese")
    @Provides
    fun provideChinese(): CountryLanguage {
        return Chinese()
    }

    @Named("english")
    @Provides
    fun provideEnglish(): CountryLanguage {
        return English()
    }

    @RussianQ
    @Provides
    fun provideRussian(): CountryLanguage {
        return Russian()
    }
}