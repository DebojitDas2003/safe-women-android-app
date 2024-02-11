package com.adds.safewomen.view

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adds.safewomen.service.MessagingService
import com.adds.safewomen.viewmodel.HomePageViewModel
import com.example.compose.Design

@Composable
fun HomePage() {
    val viewModel: HomePageViewModel = viewModel()
    MaterialTheme {


        Surface(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize() // Fill the available space
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { viewModel.onSOSButtonClicked() },
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
// Inside your activity or fragment
fun startMessagingService(context: Context) {
    val helpIntent = Intent(context, MessagingService::class.java)
    ContextCompat.startForegroundService(context, helpIntent)
}




@Composable
@Preview(showBackground = false)
fun HomePagePreview() {
    HomePage()
}
