package com.adds.safewomen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomePageViewModel : ViewModel() {

    fun onSOSButtonClicked() {
        viewModelScope.launch {
            // TODO: Handle SOS button click
        }
    }
}
