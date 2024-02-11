package com.adds.safewomen.database


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.adds.safewomen.model.Contact
import kotlinx.coroutines.flow.Flow


@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)

    @Query("SELECT * from contacts WHERE id = :id")
    fun getItem(id: Int): Flow<Contact>

    @Query("SELECT * from contacts ORDER BY name ASC")
    fun getAllContacts(): Flow<List<Contact>>

    @Query("SELECT * FROM contacts") // corrected here
    fun getAll(): List<Contact>

    @Insert
    fun insertAll(vararg contacts: Contact)
}
