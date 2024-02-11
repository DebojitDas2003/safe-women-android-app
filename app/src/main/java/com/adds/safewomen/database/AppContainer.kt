package com.adds.safewomen.database

import com.adds.safewomen.repository.ContactsRepository
import com.adds.safewomen.repository.OfflineContactsRepository



import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val contactsRepository: ContactsRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineContactsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ContactsRepository]
     */
    override val contactsRepository: ContactsRepository by lazy {
        OfflineContactsRepository(ContactDatabase.getDatabase(context).contactDao())
    }
}
