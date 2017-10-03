package org.nsdev.mypeeps.presentation.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import org.nsdev.mypeeps.R
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Contract.View {

    companion object {
        val CURRENT_TAB_ITEM: String = "CurrentTabItem"
    }

    @Inject lateinit var presenter: Contract.Presenter

    private var currentTabItem: Int = R.id.navigation_home

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        currentTabItem = item.itemId
        return@OnNavigationItemSelectedListener presenter.navigate(item.itemId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attach(this)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (savedInstanceState != null) {
            currentTabItem = savedInstanceState.getInt(CURRENT_TAB_ITEM)
            navigation.selectedItemId = currentTabItem
        } else {
            showHome()
            hideDashboard()
            hideNotifications()
        }

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(CURRENT_TAB_ITEM, currentTabItem)
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun setTitle(text: String) {
        message.text = text
    }

    override fun setTitle(text: Int) {
        message.text = getString(text)
    }

    override fun getViewModel(): MainViewModel {
        return ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun showHome() {
        homeLayout.visibility = View.VISIBLE
    }

    override fun showDashboard() {
        dashboardLayout.visibility = View.VISIBLE
    }

    override fun showNotifications() {
        notificationsLayout.visibility = View.VISIBLE
    }

    override fun hideHome() {
        homeLayout.visibility = View.GONE
    }

    override fun hideDashboard() {
        dashboardLayout.visibility = View.GONE
    }

    override fun hideNotifications() {
        notificationsLayout.visibility = View.GONE
    }

}
