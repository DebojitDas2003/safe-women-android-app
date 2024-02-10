package com.adds.safewomen.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.adds.safewomen.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE id = :userId")
    fun getUser(userId: Int): LiveData<User>

    @Update
    fun updateUser(user: User)
}