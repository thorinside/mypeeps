package org.nsdev.mypeeps.presentation.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import org.nsdev.mypeeps.app.db.User

class MainViewModel : ViewModel() {
    lateinit var users: LiveData<List<User>>
}
