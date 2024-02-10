package com.adds.safewomen.repository


import androidx.lifecycle.LiveData
import com.adds.safewomen.database.ContactDao
import com.adds.safewomen.database.UserDao
import com.adds.safewomen.model.Contact
import com.adds.safewomen.model.User

class UserRepository(private val userDao: UserDao, private val contactDao: ContactDao) {
    fun getUser(userId: Int): LiveData<User> {
        return userDao.getUser(userId)
    }

    fun addContact(userId: Int, newContact: Contact) {
        val user = getUser(userId).value
        if (user != null) {
            val updatedContacts = user.contacts.toMutableList()
            updatedContacts.add(newContact)
            user.contacts = updatedContacts
            userDao.updateUser(user)
        }
    }

    private fun saveUser(user: User?) {
        // Save the updated user back to your database
        user?.let { userDao.updateUser(it) }
    }
}
