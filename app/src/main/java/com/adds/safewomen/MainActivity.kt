package com.adds.safewomen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adds.safewomen.view.BottomNavBar
import com.adds.safewomen.view.contactPage.ContactList
import com.adds.safewomen.viewmodel.BottomNavBarViewModel


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    // Include features from X's MainActivity
                    ContactList() // Use the ContactList composable from X's package

                    // Keep the existing functionality of Y's MainActivity
                    BottomNavBar(BottomNavBarViewModel()) // Include BottomNavBar if it's part of Y's functionality
                }
            }
        }
    }
}


@Composable
@Preview()
fun AppPreview() {
    val viewModel = BottomNavBarViewModel()
    BottomNavBar(viewModel)
}