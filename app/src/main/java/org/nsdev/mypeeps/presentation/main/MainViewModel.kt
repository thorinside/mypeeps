package org.nsdev.mypeeps.presentation.main

import android.arch.lifecycle.LiveData
import org.nsdev.mypeeps.app.db.User
import org.nsdev.mypeeps.presentation.base.ViewModel

class MainViewModel : ViewModel() {
    lateinit var users: LiveData<List<User>>
}
