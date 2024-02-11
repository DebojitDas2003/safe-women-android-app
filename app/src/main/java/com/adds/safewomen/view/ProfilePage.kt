package com.adds.safewomen.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adds.safewomen.viewmodel.ProfilePageViewModel
import com.example.compose.Background
import com.example.compose.Design

class ProfilePage : ComponentActivity() {
    private val viewModel: ProfilePageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilePageContent(viewModel)
        }
    }
}

@Composable
fun ProfilePageContent(viewModel: ProfilePageViewModel) {
    val user = viewModel.user.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = user?.name ?: "No user data available")
        Text(text = user?.workplace ?: "No user data available")
        Text(text = user?.address ?: "No user data available")
    }
    Design()
}

@Composable
@Preview(showBackground = true)
fun ProfilePagePreview() {
    ProfilePageContent(ProfilePageViewModel())
}
