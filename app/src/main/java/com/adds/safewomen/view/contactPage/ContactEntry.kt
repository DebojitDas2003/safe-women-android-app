package com.adds.safewomen.view.contactPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adds.safewomen.model.Contact
import com.adds.safewomen.repository.ContactsRepository
import com.adds.safewomen.view.contactNavigation.NavigationDestination
import com.adds.safewomen.viewmodel.contactViewModel.ContactDetails
import com.adds.safewomen.viewmodel.contactViewModel.ContactEntryViewModel
import com.adds.safewomen.viewmodel.contactViewModel.ContactUiState
import com.example.compose.Background
import com.example.compose.ButtonColor
import com.example.safewomen.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

object ContactEntryDestination : NavigationDestination {
    override val route = "contact_entry"
    override val titleRes = R.string.contact_entry_title
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactEntry(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    canNavigateBack: Boolean = true,
    viewModel: ContactEntryViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(modifier = Modifier.background(Background)
    ) { innerPadding ->
        ContactEntryBody(
            contactUiState = viewModel.contactUiState,
            onContactValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.saveContact()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .background(Background)
        )
    }
}

@Composable
fun ContactEntryBody(
    contactUiState: ContactUiState,
    onContactValueChange: (ContactDetails) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large)),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))

    ) {
        ContactInputForm(
            contactDetails = contactUiState.contactDetails,
            onValueChange = onContactValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            enabled = contactUiState.isEntryValid,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.save_action),
                color = Color.White)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactInputForm(
    contactDetails: ContactDetails,
    modifier: Modifier = Modifier,
    onValueChange: (ContactDetails) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = contactDetails.name,
            onValueChange = { onValueChange(contactDetails.copy(name = it)) },
            label = { Text(stringResource(R.string.contact_name_req)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = ButtonColor,
                unfocusedContainerColor = ButtonColor,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.Gray
            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = contactDetails.phoneNumber,
            onValueChange = { onValueChange(contactDetails.copy(phoneNumber = it)) },
            label = { Text(stringResource(R.string.contact_phoneNumber_req)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = ButtonColor,
                unfocusedContainerColor = ButtonColor,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.Gray
            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = contactDetails.whatsappNumber,
            onValueChange = { onValueChange(contactDetails.copy(whatsappNumber = it)) },
            label = { Text(stringResource(R.string.contact_whatsapp_req)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = ButtonColor,
                unfocusedContainerColor = ButtonColor,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.Gray
            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = contactDetails.email,
            onValueChange = { onValueChange(contactDetails.copy(email = it)) },
            label = { Text(stringResource(R.string.contact_email_req)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = ButtonColor,
                unfocusedContainerColor = ButtonColor,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.Gray

            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        if (enabled) {
            Text(
                text = stringResource(R.string.required_fields),
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium)),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ContactEntryPreview() {
    MaterialTheme {
        ContactEntry(
            navigateBack = {},
            onNavigateUp = {},
            canNavigateBack = true,
            viewModel = ContactEntryViewModel(contactsRepository = object : ContactsRepository {
                override fun getAllContactsStream(): Flow<List<Contact>> {
                    // Return mock data or empty flow
                    return flow {
                        emit(listOf(
                            Contact(id = 1, name = "John Doe", phoneNumber = "1234567890","", ""),
                            Contact(id = 2, name = "Jane Smith", phoneNumber = "9876543210", "", "")
                        ))
                    }
                }

                override fun getContactStream(id: Int): Flow<Contact?> {
                    // Return mock data or empty flow
                    return flow {
                        emit(Contact(id = id, name = "John Doe", phoneNumber = "1234567890", "", ""))
                    }
                }

                override suspend fun insertContact(contact: Contact) {
                    // Implement mock insert operation
                    println("Inserting contact: $contact")
                }

                override suspend fun deleteContact(contact: Contact) {
                    // Implement mock delete operation
                    println("Deleting contact: $contact")
                }

                override suspend fun updateContact(contact: Contact) {
                    // Implement mock update operation
                    println("Updating contact: $contact")
                }
            })
        )
    }
}
