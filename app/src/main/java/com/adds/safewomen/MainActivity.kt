package com.adds.safewomen

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.adds.safewomen.database.ContactDatabase
import com.adds.safewomen.navigation.AppNavigation
import com.adds.safewomen.view.BottomNavBar
import com.adds.safewomen.viewmodel.BottomNavBarViewModel
import com.adds.safewomen.viewmodel.ContactPageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val db by lazy{
        Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contacts.db"
        ).build()
    }

    private val viewModel by viewModels<ContactPageViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                    extras: CreationExtras
                ): T {
                    return ContactPageViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafeWomenApp()
            MaterialTheme {
                val bottomNavBarViewModel: BottomNavBarViewModel = viewModel()
                BottomNavBar(bottomNavBarViewModel,viewModel)
            }
        }
    }
}

@Composable
fun SafeWomenApp() {
    AppNavigation()
}

