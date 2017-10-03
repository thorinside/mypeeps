package org.nsdev.mypeeps.presentation.base

import timber.log.Timber

open class BasePresenter<V : View>(protected val uiThreadQueue: UiThreadQueue) : Presenter<V> {

    protected var view: V? = null

    /**
     * True once the attach method has been called
     */
    /** Use this method to prevent re-executing portions of an attach method
     * that should only be executed once.
     * @return true when presenter is attached to view
     */
    @get:Synchronized private var isAttached: Boolean = false

    @Synchronized
    override fun attach(view: V) {
        Timber.d(">>> Presenter Attached: %s", javaClass.name)
        this.view = view
        isAttached = true
        uiThreadQueue.enabled = true
    }

    @Synchronized
    override fun detach() {
        Timber.d("<<< Presenter Detached: %s", javaClass.name)
        uiThreadQueue.enabled = false
        view = null
        isAttached = false
    }
}
