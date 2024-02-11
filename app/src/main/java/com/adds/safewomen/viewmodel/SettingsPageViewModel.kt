package com.adds.safewomen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.Background
import com.example.compose.Design
import androidx.lifecycle.ViewModel



class MySettingsViewModel : ViewModel() {
    // Your ViewModel logic here

    @Composable
    fun MySettingsPage() {
        // Retrieve or create an instance of your ViewModel
        val viewModel = viewModel<Any>()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Background
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Theme Auto", color = Color.White)
                Button(onClick = { /* Handle Edit account button click */ }) {
                    Text(text = "Edit account abc265...")
                }
                Button(
                    onClick = { /* Handle Sign Out button click */ },
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Sign Out")
                }
                Button(onClick = { /* Handle About button click */ }) {
                    Text(text = "About")
                }
            }
            Design()
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun MySettingsPagePreview() {
        SettingsPage()
    }
}