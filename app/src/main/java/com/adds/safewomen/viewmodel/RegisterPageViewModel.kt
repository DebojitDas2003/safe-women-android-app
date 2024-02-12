package com.adds.safewomen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    // Define your ViewModel properties here (e.g., user input fields, validation flags)
    var username = ""
    var email = ""
    var password = ""
    // Example function to handle registration logic
    fun onRegisterClicked(onRegisterSuccess: () -> Unit) {
        viewModelScope.launch {
            // TODO: Handle login logic here
            // If login is successful, call onLoginSuccess()
        }
    }
}
