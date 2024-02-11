package com.adds.safewomen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adds.safewomen.model.User

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
            name = "John Doe",
            workplace = "Example Company",
            address = "123 Main St",
        )
        _user.value = userData
    }
}
