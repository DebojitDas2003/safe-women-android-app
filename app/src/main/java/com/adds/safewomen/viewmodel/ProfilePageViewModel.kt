package com.adds.safewomen.viewmodel

import android.graphics.Picture
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adds.safewomen.model.User
import com.example.safewomen.R

class ProfilePageViewModel : ViewModel() {
    // LiveData to hold the user information
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    init {
        // Simulate fetching user data from a repository or other data source
        fetchUserData()
    }

    private fun fetchUserData() {
        // Simulated user data
        val userData = User(
            id = 1,
            picture = (R.drawable.profile_picture),
            name = "John Doe",
            workplace = "Example Company",
            address = "123 Main St",
        )
        _user.value = userData
    }
}
