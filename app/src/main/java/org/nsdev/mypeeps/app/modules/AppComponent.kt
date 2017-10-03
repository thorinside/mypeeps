package org.nsdev.mypeeps.app.modules

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import org.nsdev.mypeeps.App
import org.nsdev.mypeeps.presentation.main.module.Module
import javax.inject.Singleton

/**
 * Main App Component
 */
@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, AppModule::class, Module::class))
interface AppComponent {
    fun inject(app: App)
}