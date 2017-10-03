package org.nsdev.mypeeps.presentation.main

import android.support.annotation.StringRes

/**
 * Main Contract
 */
interface Contract {

    /**
     * Presenter Contract
     */
    interface Presenter : org.nsdev.mypeeps.presentation.base.Presenter<View> {
        fun navigate(id: Int): Boolean
    }

    /**
     * View Contract
     */
    interface View : org.nsdev.mypeeps.presentation.base.View {
        fun getViewModel(): MainViewModel
        fun setTitle(text: String)
        fun setTitle(@StringRes text: Int)

        fun showHome()
        fun showDashboard()
        fun showNotifications()

        fun hideHome()
        fun hideDashboard()
        fun hideNotifications()
    }
}