package org.nsdev.mypeeps.presentation.base

import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry

/**
 * A convenience class that implements {@link android.databinding.Observable} interface and provides
 * {@link #notifyPropertyChanged(int)} and {@link #notifyChange} methods.
 */
open class ViewModel : ViewModel(), android.databinding.Observable {

    val mCallbacks : PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallbacks.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallbacks.add(callback)
    }

    /**
     * Notifies listeners that all properties of this instance have changed.
     */
    @Synchronized
    open fun notifyChange() {
        mCallbacks.notifyCallbacks(this, 0, null)
    }

    /**
     * Notifies listeners that a specific property has changed. The getter for the property
     * that changes should be marked with {@link Bindable} to generate a field in
     * <code>BR</code> to be used as <code>fieldId</code>.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    open fun notifyPropertyChanged(fieldId : Int) {
        mCallbacks.notifyCallbacks(this, fieldId, null)
    }
}