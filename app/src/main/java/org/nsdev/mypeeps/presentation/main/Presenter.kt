package org.nsdev.mypeeps.presentation.main

import org.nsdev.mypeeps.R
import org.nsdev.mypeeps.app.repositories.MainRepository
import org.nsdev.mypeeps.presentation.base.BasePresenter
import org.nsdev.mypeeps.presentation.base.UiThreadQueue

class Presenter(private val mainRepository: MainRepository, uiThreadQueue: UiThreadQueue) :
        BasePresenter<Contract.View>(uiThreadQueue), Contract.Presenter {

    override fun attach(view: Contract.View) {
        super.attach(view)

        val viewModel = view.getViewModel()
        viewModel.users = mainRepository.getUserDao().getAll()
    }

    override fun navigate(id: Int): Boolean {
        when (id) {
            R.id.navigation_home -> {
                view?.setTitle(R.string.title_home)
                view?.showHome()
                view?.hideDashboard()
                view?.hideNotifications()
                return true
            }
            R.id.navigation_dashboard -> {
                view?.setTitle(R.string.title_dashboard)
                view?.hideHome()
                view?.showDashboard()
                view?.hideNotifications()
                return true
            }
            R.id.navigation_notifications -> {
                view?.setTitle(R.string.title_notifications)
                view?.hideHome()
                view?.hideDashboard()
                view?.showNotifications()
                return true
            }
        }
        return false
    }
}
