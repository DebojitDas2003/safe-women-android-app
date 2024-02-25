package com.adds.safewomen.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsPageViewModel : ViewModel() {
    // Example ViewModel logic: managing a state for the button click count
    private val _buttonClickCount = mutableStateOf(0)
    val buttonClickCount get() = _buttonClickCount.value

    fun incrementButtonClickCount() {
        _buttonClickCount.value++
    }
    private val _navigateToAboutPage = MutableLiveData<Boolean>()
     val navigateToAboutPage: LiveData<Boolean> = _navigateToAboutPage

     fun onAboutClicked() {
         _navigateToAboutPage.value = true
     }

     fun onNavigateToAboutPageComplete() {
         _navigateToAboutPage.value = false
     }
}

