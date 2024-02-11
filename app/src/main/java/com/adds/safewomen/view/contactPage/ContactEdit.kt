package com.adds.safewomen.view.contactPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adds.safewomen.view.contactNavigation.NavigationDestination
import com.adds.safewomen.viewmodel.contactViewModel.ContactEditViewModel
import com.example.compose.Background
import com.example.safewomen.R

object ContactEditDestination : NavigationDestination {
    override val route = "contact_edit"
    override val titleRes = R.string.edit_contact_title
    const val contactIdArg = "contactId"
    val routeWithArgs = "$route/{$contactIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactEdit(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    canNavigateBack: Boolean = true,
    modifier: Modifier = Modifier.fillMaxSize(),
    viewModel: ContactEditViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        ContactEntryBody(
            contactUiState = viewModel.contactUiState,
            onContactValueChange = { },
            onSaveClick = { },
            modifier = Modifier.padding(innerPadding)
                .background(Background)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ContactEditPreview(){
    ContactEdit(
        navigateBack = { /* define your navigate back action here */ },
        onNavigateUp = { /* define your on navigate up action here */ },
        canNavigateBack = true,
        modifier = Modifier,
        viewModel = ContactEditViewModel(
            savedStateHandle = SavedStateHandle(mapOf(ContactEditDestination.contactIdArg to 1)) // You might need to provide the necessary parameters to initialize your ViewModel
        )
    )
}