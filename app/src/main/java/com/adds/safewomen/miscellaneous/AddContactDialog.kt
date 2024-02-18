package com.adds.safewomen.miscellaneous

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.compose.ButtonColor


@Composable
fun AddContactDialog(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier
){
    Dialog(

        onDismissRequest = {
            onEvent(ContactEvent.HideDialog)
        }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Add Contact",
                color = Color.White)
            TextField(value = state.name, onValueChange =
            {
                onEvent(ContactEvent.SetName(it))
            },
                placeholder = {
                    Text(text = "Name")
                }
            )
            TextField(value = state.phoneNumber, onValueChange =
            {
                onEvent(ContactEvent.SetPhoneNumber(it))
            },
                placeholder = {
                    Text(text = "Phone Number")
                }
            )
            TextField(value = state.whatsappNumber, onValueChange =
            {
                onEvent(ContactEvent.SetWhatsappNumber(it))
            },
                placeholder = {
                    Text(text = "WhatsappNumber")
                }
            )
            TextField(value = state.email, onValueChange =
            {
                onEvent(ContactEvent.SetEmail(it))
            },
                placeholder = {
                    Text(text = "E-Mail ID")
                }
            )
            Button(onClick = {
                onEvent(ContactEvent.SaveContact)
            },
                colors = ButtonColors(containerColor = ButtonColor,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.Gray)
            ) {
                Text(text = "Save")
            }
        }
    }
}

@Composable
@Preview()
fun AddContactPreview() {
    AddContactDialog(state = ContactState(), onEvent = {})
}