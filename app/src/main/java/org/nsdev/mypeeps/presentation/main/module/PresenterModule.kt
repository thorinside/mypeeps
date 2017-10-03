package org.nsdev.mypeeps.presentation.main.module

import dagger.Module
import dagger.Provides
import org.nsdev.mypeeps.app.repositories.MainRepository
import org.nsdev.mypeeps.presentation.base.LifecycleAwareUiThreadQueue
import org.nsdev.mypeeps.presentation.main.Contract
import org.nsdev.mypeeps.presentation.main.MainActivity
import org.nsdev.mypeeps.presentation.main.Presenter

@Module
internal abstract class PresenterModule {
    @Module
    companion object {
        @Provides
        @Scope
        @JvmStatic internal fun providesPresenter(activity: MainActivity, mainRepository: MainRepository): Contract.Presenter {
            return Presenter(mainRepository, LifecycleAwareUiThreadQueue(activity))
        }
    }
}
