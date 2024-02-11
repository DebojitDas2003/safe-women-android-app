package com.adds.safewomen.view.contactNavigation


import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adds.safewomen.view.contactPage.ContactDestination
import com.adds.safewomen.view.contactPage.ContactDetails
import com.adds.safewomen.view.contactPage.ContactDetailsDestination
import com.adds.safewomen.view.contactPage.ContactEdit
import com.adds.safewomen.view.contactPage.ContactEditDestination
import com.adds.safewomen.view.contactPage.ContactEntry
import com.adds.safewomen.view.contactPage.ContactEntryDestination
import com.adds.safewomen.view.contactPage.ContactPage
import com.example.compose.Background


/**
 * Provides Navigation graph for the application.
 */
@Composable
fun ContactNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController, startDestination = ContactDestination.route, modifier = Modifier.background(
            Background)
    ) {
        composable(route = ContactDestination.route) {
            ContactPage(navigateToContactEntry = { navController.navigate(ContactEntryDestination.route) },
                navigateToContactUpdate = {
                    navController.navigate("${ContactDetailsDestination.route}/${it}")
                })
        }
        composable(route = ContactEntryDestination.route) {
            ContactEntry(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
        composable(
            route = ContactDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(ContactDetailsDestination.contactIdArg) {
                type = NavType.IntType
            })
        ) {
            ContactDetails(
                navigateToEditContact =
                {
                    navController.navigate("${ContactEditDestination.route}/$it")
                },
                navigateBack = { navController.navigateUp() })
        }
        composable(
            route = ContactEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ContactEditDestination.contactIdArg) {
                type = NavType.IntType
            })
        ) {
            ContactEdit(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
    }
}

@Composable
@Preview()
fun ContactNavGraphPreview() {
    val navController = rememberNavController()
    ContactNavHost(navController = navController)
}