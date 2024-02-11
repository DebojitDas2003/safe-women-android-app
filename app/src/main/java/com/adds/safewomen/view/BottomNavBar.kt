package com.adds.safewomen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.adds.safewomen.model.BottomNavigationItem
import com.adds.safewomen.view.contactPage.ContactList
import com.adds.safewomen.viewmodel.BottomNavBarViewModel
import com.example.compose.IconColor
import com.example.compose.Navbar

@Composable
fun BottomNavBar(viewModel: BottomNavBarViewModel) {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Contacts",
            selectedIcon = Icons.Filled.Phone,
            unselectedIcon = Icons.Outlined.Phone,
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



    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar(containerColor = Navbar){
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = viewModel.selectedItemIndex.value == index,
                            onClick = {
                                viewModel.onItemSelected(index)
                            },
                            label = {
                                Text(text = item.title
                                )
                            },
                            icon = {
                                Icon(
                                    imageVector = if (index == viewModel.selectedItemIndex.value) {
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = item.title,
                                )
                            },
                            colors = NavigationBarItemColors(selectedIconColor = Color.White,
                                selectedIndicatorColor = IconColor,
                                unselectedIconColor = Color.White,
                                disabledIconColor = Color.Gray,
                                disabledTextColor = Color.Gray,
                                selectedTextColor = Color.White,
                                unselectedTextColor = Color.White
                            )
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
                    .background(Navbar)
            ) {
                when (viewModel.selectedItemIndex.value) {
                    0 -> HomePage()
                    1 -> ContactList()
                    2 -> ProfilePage()
                    3 -> SettingsPage()
                }
            }
        }
    }
}

@Composable
@Preview()
fun BottomNavBarPreview() {
    val viewModel = BottomNavBarViewModel()
    BottomNavBar(viewModel)
}