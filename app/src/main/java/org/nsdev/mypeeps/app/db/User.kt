package org.nsdev.mypeeps.app.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity data class User(
        @PrimaryKey val uid: Int,
        @ColumnInfo(name = "first_name") val firstName: String,
        @ColumnInfo(name = "last_name") val lastName: String)