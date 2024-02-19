package com.adds.safewomen.view

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
                    .padding(
                        vertical = 50.dp,
                        horizontal = 15.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                OutlinedTextField(
                    value = viewModel.name,
                    onValueChange = { viewModel.name= it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    label = { Text(text = "Name*",
                        color = Color.White)},
                    singleLine = true
                )

                OutlinedTextField(
                    value = viewModel.workplace,
                    onValueChange = { viewModel.workplace= it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    label = { Text(text = "WorkPlace*",
                        color = Color.White)},
                    singleLine = true
                )

                OutlinedTextField(
                    value = viewModel.address,
                    onValueChange = { viewModel.address= it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    label = { Text(text = "Address*",
                        color = Color.White)},
                    singleLine = true
                )

                OutlinedTextField(
                    value = viewModel.username,
                    onValueChange = { viewModel.username= it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    label = { Text(text = "UserName*",
                        color = Color.White)},
                    singleLine = true
                )

                OutlinedTextField(
                    value = viewModel.email,
                    onValueChange = { viewModel.email = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    label = { Text(text = "Email*",
                        color = Color.White)}
                )


                OutlinedTextField(
                    value = viewModel.password,
                    onValueChange = { viewModel.password= it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    label = { Text(text = "Password*",
                        color = Color.White)},
                    singleLine = true
                )


                OutlinedTextField(
                    value = viewModel.password,
                    onValueChange = { viewModel.password= it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    label = { Text(text = "Confirm Password*",
                        color = Color.White)},
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { viewModel.onRegisterClicked(onRegisterSuccess) },
                    modifier = Modifier
                        .fillMaxWidth()
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


