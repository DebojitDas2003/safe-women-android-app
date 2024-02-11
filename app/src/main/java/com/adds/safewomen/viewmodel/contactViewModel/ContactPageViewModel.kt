package com.adds.safewomen.viewmodel.contactViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adds.safewomen.model.Contact
import kotlinx.coroutines.launch

class ContactPageViewModel : ViewModel() {
    // Mutable states for the TextField values
    var name = mutableStateOf("")
    var phoneNumber = mutableStateOf("")
    var whatsappNumber = mutableStateOf("")
    var email = mutableStateOf("")

    fun onAddContactClicked() {
        viewModelScope.launch {
            // TODO: Handle add contact logic here
            val newContact = Contact(
                name = name.value,
                phoneNumber = phoneNumber.value,
                whatsappNumber = whatsappNumber.value,
                email = email.value
            )
            // TODO: Add the contact to the user's contacts
            // You might want to use a repository to handle database operations.
        }
    }
}
