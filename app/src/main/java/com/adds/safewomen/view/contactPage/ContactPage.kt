package com.adds.safewomen.view.contactPage

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adds.safewomen.model.Contact
import com.adds.safewomen.view.contactNavigation.NavigationDestination
import com.example.compose.Background
import com.example.compose.Design
import com.example.compose.Navbar
import com.example.safewomen.R

object ContactDestination : NavigationDestination {
    override val route = "contact"
    override val titleRes = R.string.app_name
}

/**
 * Entry route for Home screen
 */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContactPage(
    navigateToContactEntry: () -> Unit,
    navigateToContactUpdate: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .background(color = Background),
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToContactEntry,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),

            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.contact_entry_title)
                )
            }
        },
    ) { innerPadding ->
        ContactBody(
            contactList = listOf(),
            onContactClick = navigateToContactUpdate,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
    Design()
}

@Composable
private fun ContactBody(
    contactList: List<Contact>, onContactClick: (Int) -> Unit, modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.background(Background)
    ) {
        if (contactList.isEmpty()) {
            Text(
                text = stringResource(R.string.no_contact_description),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White

            )
        } else {
            ContactList(
                contactList = contactList,
                onContactClick = { onContactClick(it.id) },
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
            )
        }
    }

}

@Composable
private fun ContactList(
    contactList: List<Contact>, onContactClick: (Contact) -> Unit, modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items = contactList, key = { it.id }) { contact ->
            ContactItem(contact = contact,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .clickable { onContactClick(contact) })
        }
    }
}

@Composable
private fun ContactItem(
    contact: Contact, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Navbar,
            contentColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = contact.name,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = contact.phoneNumber,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ContactBodyPreview() {
    MaterialTheme {


        ContactBody(listOf(
            Contact(1, "Debojit", "9830105207", "9830105207", "www.www@www.com"), Contact(2, "Debosmita", "8334003175", "9830105207", "www.www@www.com"), Contact(3, "Debz", "8334003175", "9830105207", "www.www@www.com")
        ), onContactClick = {})
    }
}

@Preview(showBackground = false)
@Composable
fun ContactBodyEmptyListPreview() {
    MaterialTheme {

        ContactBody(listOf(), onContactClick = {})
    }
}

@Preview(showBackground = false)
@Composable
fun ContactItemPreview() {
    MaterialTheme {

        ContactItem(
            Contact(1, "debojit", "9563124521", "9830105207", "www.www@www.com"),
        )
    }
}

@Preview()
@Composable
fun ContactPagePreview() {
    ContactPage(navigateToContactEntry = { /*TODO*/ }, navigateToContactUpdate = { _ -> /*TODO*/ })
}
