package org.nsdev.mypeeps

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import org.nsdev.mypeeps.app.modules.AppComponent
import org.nsdev.mypeeps.app.modules.AppModule
import org.nsdev.mypeeps.app.modules.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject

/**
 * App
 */

class App : Application(), HasActivityInjector, HasSupportFragmentInjector {
    @Inject
    internal lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    internal lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    private val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingFragmentInjector
    }
}
