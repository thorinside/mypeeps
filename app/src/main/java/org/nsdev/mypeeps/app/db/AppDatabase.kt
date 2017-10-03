package org.nsdev.mypeeps.app.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by nealsanche on 2017-10-03.
 */

@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}