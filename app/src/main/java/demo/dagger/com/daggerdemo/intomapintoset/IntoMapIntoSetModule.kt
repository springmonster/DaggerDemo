package demo.dagger.com.daggerdemo.intomapintoset

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey

/**
 * @author Charles.Kuang
 */
@Module
class IntoMapIntoSetModule {
    @Provides
    @IntoSet
    fun provideStringA(): String {
        return "A"
    }

    @Provides
    @IntoSet
    fun provideStringB(): String {
        return "B"
    }

    @Provides
    @IntoSet
    fun provideStringC(): String {
        return "C"
    }

    @Provides
    @IntoMap
    @StringKey("AA")
    fun providesStringAA(): String {
        return "AA"
    }

    @Provides
    @IntoMap
    @StringKey("BB")
    fun providesStringBB(): String {
        return "BB"
    }

    @Provides
    @IntoMap
    @StringKey("CC")
    fun providesStringCC(): String {
        return "CC"
    }
}