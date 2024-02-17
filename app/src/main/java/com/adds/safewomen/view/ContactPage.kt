package com.adds.safewomen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adds.safewomen.miscellaneous.AddContactDialog
import com.adds.safewomen.miscellaneous.ContactEvent
import com.adds.safewomen.miscellaneous.ContactState
import com.adds.safewomen.miscellaneous.SortType
import com.adds.safewomen.model.Contact
import com.example.compose.Background
import com.example.compose.ButtonColor
import com.example.compose.Design


@Composable
fun ContactPage(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit
){
    Scaffold(
        containerColor = Background,
        floatingActionButton = {
        FloatingActionButton(onClick = {
            onEvent(ContactEvent.ShowDialog)
        },
            containerColor = ButtonColor,
            contentColor = Color.White
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Contact"
            )
        }
    },


    ) {padding ->
        if(state.isAddingContact) {
            AddContactDialog(state = state, onEvent = onEvent)
        }
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )
        {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SortType.values().forEach { sortType ->
                        Row(
                            modifier = Modifier
                                .clickable{
                                    onEvent(ContactEvent.SortContacts(sortType))
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(selected = state.sortType == sortType,
                                onClick = {
                                    onEvent(ContactEvent.SortContacts(sortType))
                                },
                                colors = RadioButtonColors(selectedColor = Color.White,
                                    unselectedColor = Color.Gray,
                                    disabledSelectedColor = Color.DarkGray,
                                    disabledUnselectedColor = Color.DarkGray)
                            )
                            Text(text = sortType.name,
                                color = Color.White)
                        }
                    }
                }
            }
            items(state.contacts) {  contact ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = ButtonColor,
                            shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp)
                        )
                        .height(80.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = contact.name,
                            fontSize = 20.sp,
                            color= Color.White
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text  = contact.phoneNumber,
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                    IconButton(onClick = {
                        onEvent(ContactEvent.DeleteContact(contact))
                    }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Contact",
                            tint = Color.White)

                    }
                }
            }
        }
        Design()

    }
}



@Composable
@Preview
fun ContactPagePreview() {
    val dummyContactState = ContactState(
        contacts = listOf(
            Contact(name = "John Doe", phoneNumber = "1234567890", whatsappNumber = "", email = ""),
            Contact(name = "Jane Doe", phoneNumber = "0987654321", whatsappNumber = "", email = "")
            // Add more dummy contacts if needed
        ),
        sortType = SortType.NAME,
        isAddingContact = false // or true if you want to preview adding a contact dialog
    )
        // Handle contact events here
    }
