package com.adds.safewomen.model

import androidx.room.Entity

@Entity
data class Contact(
    val name: String,
    val phoneNumber: String,
    val whatsappNumber: String
)