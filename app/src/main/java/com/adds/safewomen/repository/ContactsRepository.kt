package com.adds.safewomen.repository


import com.adds.safewomen.model.Contact
import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Contact] from a given data source.
 */
interface ContactsRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllContactsStream(): Flow<List<Contact>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getContactStream(id: Int): Flow<Contact?>

    /**
     * Insert item in the data source
     */
    suspend fun insertContact(contact: Contact)

    /**
     * Delete item from the data source
     */
    suspend fun deleteContact(contact: Contact)

    /**
     * Update item in the data source
     */
    suspend fun updateContact(contact: Contact)
}

