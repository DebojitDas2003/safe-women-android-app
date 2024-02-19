package com.adds.safewomen.database


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.adds.safewomen.model.Contact
import kotlinx.coroutines.flow.Flow


@Dao
interface ContactDao {

    @Upsert
    suspend fun upsert(contact: Contact)


    @Delete
    suspend fun delete(contact: Contact)


    @Query("SELECT * from contact ORDER BY name ASC")
    fun getAllContactsByName(): Flow<List<Contact>>

    @Query("SELECT * from contact ORDER BY phoneNumber ASC")
    fun getAllContactsByPhoneNumber(): Flow<List<Contact>>

    @Query("SELECT * from contact ORDER BY whatsappNumber ASC")
    fun getAllContactsByWhatsappNumber(): Flow<List<Contact>>

    @Query("SELECT * from contact ORDER BY email ASC")
    fun getAllContactsByEmail(): Flow<List<Contact>>

    @Query("SELECT phoneNumber FROM contact")
    fun getAllPhoneNumbers(): Flow<List<String>>
}
