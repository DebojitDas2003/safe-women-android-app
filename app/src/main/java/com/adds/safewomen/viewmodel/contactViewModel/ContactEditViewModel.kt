package com.adds.safewomen.viewmodel.contactViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.adds.safewomen.view.contactPage.ContactEditDestination

/**
 * ViewModel to retrieve and update an item from the [ItemsRepository]'s data source.
 */
open class ContactEditViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var contactUiState by mutableStateOf(ContactUiState())

    private val contactId: Int = savedStateHandle.get(ContactEditDestination.contactIdArg)
        ?: throw IllegalArgumentException("contactId is required in the saved state")

    private fun validateInput(uiState: ContactDetails = contactUiState.contactDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && phoneNumber.isNotBlank()
        }
    }
}
