package com.adds.safewomen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginPageViewModel : ViewModel() {
    var email = ""
    var password = ""

    fun onLoginClicked(onLoginSuccess: () -> Unit) {
        viewModelScope.launch {
            // TODO: Handle login logic here
            // If login is successful, call onLoginSuccess()
        }
    }
}
