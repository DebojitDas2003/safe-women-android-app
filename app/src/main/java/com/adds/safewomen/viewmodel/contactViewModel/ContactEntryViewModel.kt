package com.adds.safewomen.viewmodel.contactViewModel



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.adds.safewomen.model.Contact
import com.adds.safewomen.repository.ContactsRepository


class ContactEntryViewModel(private val contactsRepository: ContactsRepository) : ViewModel() {

    var contactUiState by mutableStateOf(ContactUiState())
        private set

    fun updateUiState(contactDetails: ContactDetails) {
        contactUiState =
            ContactUiState(contactDetails = contactDetails, isEntryValid = validateInput(contactDetails))
    }

    suspend fun saveContact() {
        if (validateInput()) {
            contactsRepository.insertContact(contactUiState.contactDetails.toContact())
        }
    }

    private fun validateInput(uiState: ContactDetails = contactUiState.contactDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && phoneNumber?.isNotBlank() == true
        }
    }
}


data class ContactUiState(
    val contactDetails: ContactDetails = ContactDetails(),
    val isEntryValid: Boolean = false
)

data class ContactDetails(
    val id: Int = 0,
    val name: String = "",
    val phoneNumber: String = "",
    val whatsappNumber: String = "",
    val email: String = "",
)


fun ContactDetails.toContact(): Contact = Contact(
    id = id,
    name = name,
    phoneNumber = phoneNumber,
    whatsappNumber = whatsappNumber,
    email = email,
)



fun Contact.toContactUiState(isEntryValid: Boolean = false): ContactUiState = ContactUiState(
    contactDetails = this.toContactDetails(),
    isEntryValid = isEntryValid
)

fun Contact.toContactDetails(): ContactDetails = ContactDetails(
    id = id,
    name = name,
    phoneNumber = phoneNumber,
    whatsappNumber = whatsappNumber,
    email = email
)
