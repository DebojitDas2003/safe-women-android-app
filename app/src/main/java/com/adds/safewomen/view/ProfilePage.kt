package com.adds.safewomen.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adds.safewomen.viewmodel.ProfilePageViewModel
import com.example.compose.Background
import com.example.compose.Design

@Composable
fun ProfilePage() {
    val viewModel = remember { ProfilePageViewModel() }

    ProfilePageContent(viewModel)
}
@Composable
fun ProfilePageContent(viewModel: ProfilePageViewModel) {
    val user = viewModel.user.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            ,
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
