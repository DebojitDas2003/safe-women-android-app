package com.adds.safewomen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adds.safewomen.model.Contact
import kotlinx.coroutines.launch

class ContactPageViewModel : ViewModel() {
    var name = ""
    var phoneNumber = ""
    var whatsappNumber = ""

    fun onAddContactClicked() {
        viewModelScope.launch {
            // TODO: Handle add contact logic here
            val newContact = Contact(name, phoneNumber, whatsappNumber)
            // TODO: Add the contact to the user's contacts
        }
    }
}
