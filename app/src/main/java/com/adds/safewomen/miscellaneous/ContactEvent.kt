package com.adds.safewomen.miscellaneous

import com.adds.safewomen.model.Contact

sealed interface ContactEvent {
    object SaveContact: ContactEvent
    data class SetName(val name: String): ContactEvent
    data class SetPhoneNumber(val phoneNumber: String): ContactEvent
    data class SetWhatsappNumber(val whatsappNumber: String): ContactEvent
    data class SetEmail(val email: String): ContactEvent
    object ShowDialog: ContactEvent
    object HideDialog: ContactEvent
    data class SortContacts(val sortType: SortType): ContactEvent
    data class DeleteContact(val contact: Contact): ContactEvent
}