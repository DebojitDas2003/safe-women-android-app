package com.adds.safewomen.viewmodel

import android.graphics.Picture
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adds.safewomen.viewmodel.User.Companion.DEFAULT_ADDRESS
import com.adds.safewomen.viewmodel.User.Companion.DEFAULT_NAME
import com.adds.safewomen.viewmodel.User.Companion.DEFAULT_WORKPLACE
import com.adds.safewomen.viewmodel.User.Companion.ID
import com.adds.safewomen.viewmodel.User.Companion.PROFILE_PICTURE_URL
import com.example.safewomen.R

data class User(
    val id: String,
    var name: String,
    var workplace: String,
    var address: String,
    var profilePictureUrl: String // Assuming the profile picture is stored as a URL
) {
    companion object {
        const val DEFAULT_NAME = "John Doe"
        const val DEFAULT_WORKPLACE = "Example Company"
        const val DEFAULT_ADDRESS = "123 Main St"
        const val PROFILE_PICTURE_URL = "https://c.stocksy.com/a/LTd000/z9/151735.jpg"
        const val ID = "id123456789"
    }





class ProfilePageViewModel : ViewModel() {
    // LiveData to hold the user information
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    init {
        // Simulate fetching user data from a repository or other data source
        fetchUserData()
    }

    private fun fetchUserData() {
        // Simulated user data

        val userData = User(
            picture = (R.drawable.profile_picture),
            id = ID, // provide a value for id here
            name = DEFAULT_NAME,
            workplace = DEFAULT_ADDRESS,
            address = DEFAULT_WORKPLACE,
            profilePictureUrl = PROFILE_PICTURE_URL
        )
        _user.value = userData
    }
    fun updateUserProfile(updatedUser: User) {
        // Update the user information in the repository or data source
        _user.value = updatedUser
    }
}}
