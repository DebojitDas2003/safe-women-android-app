package com.adds.safewomen.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class BottomNavBarViewModel : ViewModel() {
    // This is the index of the currently selected screen.
    val selectedItemIndex = mutableIntStateOf(0)

    fun onItemSelected(index: Int) {
        selectedItemIndex.value = index
    }
}