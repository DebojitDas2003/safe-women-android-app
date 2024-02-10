package com.adds.safewomen.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adds.safewomen.model.Contact

@Database(entities = [Contact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}