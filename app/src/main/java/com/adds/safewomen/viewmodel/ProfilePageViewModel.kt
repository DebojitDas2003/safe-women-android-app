package com.adds.safewomen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.adds.safewomen.model.User
import kotlinx.coroutines.flow.MutableStateFlow

class ProfilePageViewModel : ViewModel() {
    // Assuming you have a User data class with fields name, workplace, and address
    private val _user = MutableStateFlow<User?>(null)
    val user = _user.asLiveData()

    fun loadUser() {
        // TODO: Load the user data here
    }
}
