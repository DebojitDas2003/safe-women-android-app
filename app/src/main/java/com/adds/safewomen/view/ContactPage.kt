package com.adds.safewomen.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adds.safewomen.viewmodel.ContactPageViewModel

class ContactPage : ComponentActivity() {
    private val viewModel: ContactPageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactPageContent(viewModel)
        }
    }
}

@Composable
fun ContactPageContent(viewModel: ContactPageViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            value = viewModel.name.value,
            onValueChange = { newValue -> viewModel.name.value = newValue },
            label = { Text("Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            singleLine = true
        )
        TextField(
            value = viewModel.phoneNumber.value,
            onValueChange = { newValue -> viewModel.phoneNumber.value = newValue },
            label = { Text("Phone Number") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            singleLine = true
        )
        TextField(
            value = viewModel.whatsappNumber.value,
            onValueChange = { newValue -> viewModel.whatsappNumber.value = newValue },
            label = { Text("WhatsApp Number") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            singleLine = true
        )
        Button(onClick = { viewModel.onAddContactClicked() }) {
            Text(text = "Add Contact")
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ContactPagePreview() {
    ContactPageContent(ContactPageViewModel())
}
