package com.adds.safewomen.viewmodel.contactViewModel


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.adds.safewomen.view.contactPage.ContactDetailsDestination


class ContactDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val ContactId: Int = checkNotNull(savedStateHandle[ContactDetailsDestination.contactIdArg])


}


data class ContactDetailsUiState(
    val contactDetails: ContactDetails = ContactDetails()
)
