package com.adds.safewomen.repository

import androidx.lifecycle.LiveData
import com.adds.safewomen.database.UserDao
import com.adds.safewomen.model.User

class UserRepository(private val userDao: UserDao) {
    fun getUser(userId: Int): LiveData<User> {
        return userDao.getUser(userId)
    }

    // If you have any other methods related to user management, you can add them here
}
