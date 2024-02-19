package com.adds.safewomen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adds.safewomen.viewmodel.SettingsPageViewModel
import com.example.compose.Background
import com.example.compose.ButtonColor
import com.example.compose.Design

@Composable
fun SettingsPage() {
    // Retrieve or create an instance of your ViewModel
    val viewModel = viewModel<SettingsPageViewModel>()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = { /* Handle About button click */ },
                colors = ButtonColors(containerColor = ButtonColor,
                    contentColor = Color.White,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.Gray,
                ),
                modifier = Modifier.width(150.dp),
                shape = AbsoluteRoundedCornerShape(10.dp,0.dp,10.dp,0.dp),) {
                Text(text = "About")
            }

            Spacer(modifier = Modifier.size(20.dp))

            Button(onClick = { /* Handle About button click */ },
                colors = ButtonColors(containerColor = ButtonColor,
                    contentColor = Color.White,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.Gray,
                ),
                modifier = Modifier.width(150.dp),
                shape = AbsoluteRoundedCornerShape(10.dp,0.dp,10.dp,0.dp),) {
                Text(text = "Permissions")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /* Handle Sign Out button click */ },
                shape = AbsoluteRoundedCornerShape(10.dp,0.dp,10.dp,0.dp),
                colors = ButtonDefaults.buttonColors(Color.Red),
                modifier = Modifier.width(150.dp)
            ) {
                Text(text = "Sign Out")
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

