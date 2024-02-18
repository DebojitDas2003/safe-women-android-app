package com.adds.safewomen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adds.safewomen.database.ContactDao
import com.adds.safewomen.miscellaneous.ContactEvent
import com.adds.safewomen.miscellaneous.ContactState
import com.adds.safewomen.miscellaneous.SortType
import com.adds.safewomen.model.Contact
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContactPageViewModel(private val dao: ContactDao) : ViewModel() {
    private val _sortType = MutableStateFlow(SortType.NAME)
    @OptIn(ExperimentalCoroutinesApi::class)
    private val _contacts = _sortType
        .flatMapLatest { sortType ->
            when (sortType) {
                SortType.NAME -> dao.getAllContactsByName()
                SortType.PHONE_NUMBER -> dao.getAllContactsByPhoneNumber()
                SortType.WHATSAPP_NUMBER -> dao.getAllContactsByWhatsappNumber()
                SortType.EMAIL -> dao.getAllContactsByEmail()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _state = MutableStateFlow(ContactState())

    val state = combine(_state, _sortType, _contacts) { state, sortType, contacts ->
        state.copy(
            contacts = contacts,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ContactState())

    fun onEvent(event: ContactEvent) {
        when (event) {
            is ContactEvent.DeleteContact -> {
                viewModelScope.launch {
                    dao.delete(event.contact)
                }
            }
            ContactEvent.HideDialog -> {
                _state.value = _state.value.copy(isAddingContact = false)
            }
            ContactEvent.SaveContact -> {
                val name = state.value.name
                val phoneNumber = state.value.phoneNumber
                val whatsappNumber = state.value.whatsappNumber
                val email = state.value.email

                if (name.isBlank() || phoneNumber.isBlank()) {
                    return
                }

                val contact = Contact(
                    name = name,
                    phoneNumber = phoneNumber,
                    whatsappNumber = whatsappNumber,
                    email = email
                )
                viewModelScope.launch {
                    dao.upsert(contact)
                }
                _state.update { it.copy(
                    isAddingContact = false,
                    name = "",
                    phoneNumber = "",
                    whatsappNumber = "",
                    email = ""
                ) }
            }
            is ContactEvent.SetEmail -> {
                _state.value = _state.value.copy(email = event.email)
            }
            is ContactEvent.SetName -> {
                _state.value = _state.value.copy(name = event.name)
            }
            is ContactEvent.SetPhoneNumber -> {
                _state.value = _state.value.copy(phoneNumber = event.phoneNumber)
            }
            is ContactEvent.SetWhatsappNumber -> {
                _state.value = _state.value.copy(whatsappNumber = event.whatsappNumber)
            }
            ContactEvent.ShowDialog -> {
                _state.value = _state.value.copy(isAddingContact = true)
                Log.d("showdialog","show dialog")
            }
            is ContactEvent.SortContacts -> {
                _sortType.value = event.sortType
            }
        }
    }
}