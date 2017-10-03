package org.nsdev.mypeeps.app.repositories

import org.nsdev.mypeeps.App
import org.nsdev.mypeeps.app.db.AppDatabase
import org.nsdev.mypeeps.app.db.UserDao

class MainRepository(val app: App, private val database: AppDatabase) {
    fun getUserDao(): UserDao {
        return database.userDao()
    }
}
