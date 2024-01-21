package com.example.safewomen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.safewomen.ui.theme.SafeWomenTheme

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                // Handle button click
            },
            modifier = Modifier
                .size(200.dp) // Adjust the size as needed
                .padding(16.dp)
        ) {
            Text(text = "Help", fontSize = 50.sp)
        }
        // Your content goes here
    }
    }


@Composable
fun AddContactScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Demo data
        val demoContacts = listOf(
            "John Doe (123) 456-7890",
            "Jane Smith (987) 654-3210",
            "Alice Johnson (111) 222-3333",
            // Add more demo contacts as needed
        )

        // Display demo contacts
        LazyColumn {
            items(demoContacts.size) { index ->
                ContactListItem(nameAndNumber = demoContacts[index])
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Button to add more contacts (not functional in this MVP)
        Button(
            onClick = {
                // Add functionality here to handle the button click
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Add More Contacts")
        }
    }
}


@Composable
fun ContactListItem(nameAndNumber: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                // Handle click on the contact item (e.g., open contact details)
            }
    ) {
        Text(
            text = nameAndNumber,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                .padding(8.dp)
                .clip(MaterialTheme.shapes.medium)
        )
    }
}

@Composable
fun ProfileScreen() {
    // Sample user data (replace with actual user data)
    val userName = "Karen Doe"
    val officeName = "Google"
    val address = "99/1, S. N. R. Lane"
    val zipCode = "Kolkata- 7000154"
    val userImage = painterResource(id = R.drawable.profile_picture) // Replace with the actual image resource

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile picture
        Image(
            painter = userImage,
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // User name
        Text(
            text = userName,
            modifier = Modifier.padding(8.dp)
        )

        // User bio
        Text(
            text = "Office: "  + officeName,
            modifier = Modifier.padding(8.dp)
        )

        Text(
            text = "Address: "  + address,
            modifier = Modifier.padding(8.dp)
        )

        Text(
            text = zipCode,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Edit profile button
        Button(
            onClick = {
                // Handle edit profile button click
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Edit Profile")
        }
    }
}


@Composable
fun SettingsScreen() {
    // Remember the current theme switch state
    var isDarkTheme by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Toggle button for switching theme
        Switch(
            checked = isDarkTheme,
            onCheckedChange = {
                // Handle theme switch
                isDarkTheme = it
                // You can implement theme switching logic here
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Placeholder for other essential settings options
        LazyColumn {
            item {
                SettingsOption("Option 1", "Description for Option 1") {
                    // Handle Option 1 click
                }
            }

            item {
                SettingsOption("Option 2", "Description for Option 2") {
                    // Handle Option 2 click
                }
            }

            // Add more settings options as needed
        }
    }
}

@Composable
fun SettingsOption(title: String, description: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(8.dp)
        )

        Text(
            text = description,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafeWomenTheme {
                AppContent()
            }
        }
    }

    @Composable
    fun AppContent() {
        val items = listOf(
            BottomNavigationItem(
                title = "Home",
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
                hasNews = false,
            ),
            BottomNavigationItem(
                title = "Add Contact",
                selectedIcon = Icons.Filled.Add,
                unselectedIcon = Icons.Outlined.Add,
                hasNews = false,
            ),
            BottomNavigationItem(
                title = "Profile",
                selectedIcon = Icons.Filled.AccountCircle,
                unselectedIcon = Icons.Outlined.AccountCircle,
                hasNews = true,
            ),
            BottomNavigationItem(
                title = "Settings",
                selectedIcon = Icons.Filled.Settings,
                unselectedIcon = Icons.Outlined.Settings,
                hasNews = true,
            )
        )

        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                },
                                label = {
                                    Text(text = item.title)
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) {
                                            item.selectedIcon
                                        } else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            )
                        }
                    }
                }
            ) { innerPadding ->
                // Content padding is applied using innerPadding
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    when (selectedItemIndex) {
                        0 -> HomeScreen()
                        1 -> AddContactScreen()
                        2 -> ProfileScreen()
                        3 -> SettingsScreen()
                    }
                }
            }
        }
    }
}