package com.adds.safewomen.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id: Int,
    val name: String,
    val workplace: String,
    val address: String
)
