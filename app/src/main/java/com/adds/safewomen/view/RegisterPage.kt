package com.adds.safewomen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adds.safewomen.viewmodel.RegisterViewModel
import com.example.compose.Background
import com.example.compose.Design


@Composable
fun RegisterPage(onRegisterSuccess: () -> Unit) {
    MaterialTheme {
        val viewModel: RegisterViewModel = viewModel()

        Surface(color = Background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Username",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 10.dp),
                    color = (Color.White)
                )
                OutlinedTextField(
                    value = viewModel.username,
                    onValueChange = { viewModel.username= it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    singleLine = true
                )
                Text(
                    text = "Email Address",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 10.dp),
                    color = (Color.White)
                )
                OutlinedTextField(
                    value = viewModel.email,
                    onValueChange = { viewModel.email = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                )

                Text(
                    text = "Create password",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 10.dp),
                    color = (Color.White)
                )
                OutlinedTextField(
                    value = viewModel.password,
                    onValueChange = { viewModel.password= it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    singleLine = true
                )

                Text(
                    text = "Verify Password",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 10.dp),
                    color = (Color.White)
                )
                OutlinedTextField(
                    value = viewModel.password,
                    onValueChange = { viewModel.password= it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { viewModel.onRegisterClicked(onRegisterSuccess) },
                    modifier = Modifier.fillMaxWidth()
                        .padding(15.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(text = "Register")
                }
            }
            Design()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RegisterPagePreview() {
    RegisterPage(onRegisterSuccess = {})
}


