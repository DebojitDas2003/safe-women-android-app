package com.adds.safewomen.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adds.safewomen.miscellaneous.ContactEvent
import com.adds.safewomen.miscellaneous.ContactState
import com.adds.safewomen.view.ContactPage
import com.adds.safewomen.view.HomePage
import com.adds.safewomen.view.ProfilePage
import com.adds.safewomen.view.SettingsPage
import com.adds.safewomen.viewmodel.SettingsPageViewModel

sealed class Screen(val route: String) {
    object HomePage : Screen("home")
    object ContactPage : Screen("contact")
    object ProfilePage : Screen("profile")
    object SettingsPage : Screen("settings") {
        object AboutPage : Screen("about")
    }
}

fun NavGraphBuilder.addSafeWomanAppNavigation(navController: NavHostController, settingsViewModel: SettingsPageViewModel) {
    composable(Screen.HomePage.route) { HomePage() }
    composable(Screen.ContactPage.route) { ContactPage(
        onEvent = { event: ContactEvent ->Unit },
        state = ContactState()
    ) }
    composable(Screen.ProfilePage.route) { ProfilePage() }
    composable(Screen.SettingsPage.route) { SettingsPage(navController, settingsViewModel ) }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val settingsViewModel = viewModel<SettingsPageViewModel>()
    NavHost(navController = navController, startDestination = Screen.HomePage.route) {
        addSafeWomanAppNavigation(navController=navController,settingsViewModel)
    }
}



