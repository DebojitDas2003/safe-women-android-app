package com.adds.safewomen.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.adds.safewomen.model.Contact


@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>

    @Insert
    fun insertAll(vararg contacts: Contact)
}