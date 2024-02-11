package com.adds.safewomen.view.contactPage


import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.adds.safewomen.view.contactNavigation.ContactNavHost

/**
 * Top level composable that represents screens for the application.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContactList(navController: NavHostController = rememberNavController()) {
    ContactNavHost(navController = navController)

}

/**
 * App bar to display title and conditionally display the back navigation.
 */



@Composable
@Preview(showBackground = false)
fun ContactListPreview(){
    ContactList()
}