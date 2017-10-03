package org.nsdev.mypeeps.app.modules

import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import org.nsdev.mypeeps.App
import org.nsdev.mypeeps.app.db.AppDatabase
import org.nsdev.mypeeps.app.repositories.MainRepository
import javax.inject.Singleton

/**
 * App Module
 */

@Module
class AppModule(val app: App) {
    @Provides
    @Singleton
    fun provideApp() = app

    @Provides
    @Singleton
    fun provideAppDatabase(app: App): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "database-name").build()
    }

    @Provides
    @Singleton
    fun provideMainRepository(database: AppDatabase) = MainRepository(app, database)
}