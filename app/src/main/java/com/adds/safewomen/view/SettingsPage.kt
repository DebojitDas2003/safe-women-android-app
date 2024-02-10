package com.adds.safewomen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Settings", color = Color.White)
            //Image(painter = painterResource(id = R.drawable.user_icon), contentDescription = "User Icon")
            Text(text = "Theme Auto", color = Color.White)
            Button(onClick = { /*TODO: Handle Edit account button click*/ }) {
                Text(text = "Edit account abc265...")
            }
            Button(onClick = { /*TODO: Handle Sign Out button click*/ }, colors = ButtonDefaults.buttonColors(Color.Red)) {
                Text(text = "Sign Out")
            }
            Button(onClick = { /*TODO: Handle About button click*/ }) {
                Text(text = "About")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SettingsPagePreview() {
    SettingsPage()
}
