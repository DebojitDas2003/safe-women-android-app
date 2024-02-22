package com.adds.safewomen.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel


class PermissionDialogViewModel: ViewModel() {

    val visiblePermissionDialogQueue = mutableStateListOf<String>()

    fun dismissDialog() {
        visiblePermissionDialogQueue.removeLast()

    }

    fun onPermissionResult(
        permission: String,
        isGranted: Boolean
    ) {
        if (!isGranted && !visiblePermissionDialogQueue.contains(permission)) {
            visiblePermissionDialogQueue.add(permission)
        }

    }
}