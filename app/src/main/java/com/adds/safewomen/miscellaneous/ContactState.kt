package com.adds.safewomen.miscellaneous

import com.adds.safewomen.model.Contact

data class ContactState(
    val contacts: List<Contact> = emptyList(),
    val name: String = "",
    val phoneNumber: String = "",
    val whatsappNumber: String = "",
    val email: String = "",
    val isAddingContact: Boolean = false,
    val sortType: SortType = SortType.NAME
)
