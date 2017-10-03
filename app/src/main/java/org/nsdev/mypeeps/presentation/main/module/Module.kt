package org.nsdev.mypeeps.presentation.main.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.nsdev.mypeeps.presentation.main.MainActivity

@Module
internal abstract class Module {
    @Scope
    @ContributesAndroidInjector(modules = arrayOf(PresenterModule::class))
    abstract fun provideActivityInjector(): MainActivity
}