package com.adds.safewomen.repository


import com.adds.safewomen.database.ContactDao
import com.adds.safewomen.model.Contact
import kotlinx.coroutines.flow.Flow

class OfflineContactsRepository(private val contactDao: ContactDao) : ContactsRepository {
    override fun getAllContactsStream(): Flow<List<Contact>> = contactDao.getAllContacts()

    override fun getContactStream(id: Int): Flow<Contact?> = contactDao.getItem(id)

    override suspend fun insertContact(contact: Contact) = contactDao.insert(contact)

    override suspend fun deleteContact(contact: Contact) = contactDao.delete(contact)

    override suspend fun updateContact(contact: Contact) = contactDao.update(contact)
}
