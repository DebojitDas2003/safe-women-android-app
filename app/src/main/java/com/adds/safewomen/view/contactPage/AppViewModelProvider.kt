package com.adds.safewomen.view.contactPage


import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.adds.safewomen.viewmodel.contactViewModel.ContactDetailsViewModel
import com.adds.safewomen.viewmodel.contactViewModel.ContactEditViewModel
import com.adds.safewomen.viewmodel.contactViewModel.ContactEntryViewModel
import com.adds.safewomen.viewmodel.contactViewModel.ContactListApplication


/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer {
            ContactEditViewModel(
                this.createSavedStateHandle()
            )
        }
        // Initializer for ItemEntryViewModel
        initializer {
            ContactEntryViewModel(contactApplication().container.contactsRepository)
        }

        // Initializer for ItemDetailsViewModel
        initializer {
            ContactDetailsViewModel(
                this.createSavedStateHandle()
            )
        }

    }
}


fun CreationExtras.contactApplication(): ContactListApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ContactListApplication)
