package com.adds.safewomen.view

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adds.safewomen.service.MessagingService
import com.example.compose.Background
import com.example.compose.Design

@Composable
fun HomePage() {
    // Obtain the current context
    val context = LocalContext.current

    // Call the service when the button is pressed
    val onHelpButtonClicked: () -> Unit = {
        val messagingServiceIntent = Intent(context, MessagingService::class.java)
        context.startService(messagingServiceIntent)
    }

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), // Fill the available space
            color = Background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = onHelpButtonClicked, // Call the service when the button is clicked
                    colors = buttonColors(Color.Red),
                    modifier = Modifier
                        .size(200.dp)
                        .padding(16.dp)
                ) {
                    Text(text = "Help", fontSize = 50.sp)
                }
            }
            Design()
        }
    }
}




@Composable
@Preview(showBackground = false)
fun HomePagePreview() {
    HomePage()
}
