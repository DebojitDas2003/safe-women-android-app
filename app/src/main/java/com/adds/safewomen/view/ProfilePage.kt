package com.adds.safewomen.view


import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.adds.safewomen.viewmodel.User
import com.example.compose.Background
import com.example.compose.ButtonColor
import com.example.compose.Design
import com.example.safewomen.R



@Composable
fun ProfilePage() {
    val viewModel = remember { User.ProfilePageViewModel() }

    ProfilePageContent(viewModel)
}
@Composable
fun ProfilePageContent(viewModel: User.ProfilePageViewModel) {

    val user = viewModel.user.value
    val context = LocalContext.current

    // State to hold the selected image URI
    val selectedImageUri = remember { mutableStateOf<String?>(null) }

    // Image picker launcher
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        selectedImageUri.value = uri?.toString()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ProfilePicture(
                profilePictureUrl = selectedImageUri.value ?: user?.profilePictureUrl,
                modifier = Modifier
                    .size(120.dp)
                    .clickable {
                        // Launch image picker
                        imagePickerLauncher.launch("profile_picture.jpg")
                    },
                shape = CircleShape
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = user?.name ?: "No user data available",
                color = Color.White,
                fontSize = 60.sp,
                fontFamily = FontFamily.Cursive,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = user?.workplace ?: "No user data available",
                color = Color.White,
                fontSize = 45.sp,
                fontStyle = FontStyle.Italic

            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = user?.address ?: "No user data available",
                color = Color.White,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            Button(colors = ButtonColors(
                containerColor = ButtonColor,
                contentColor = Color.White,
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.Gray,
            ),
                shape = AbsoluteRoundedCornerShape(10.dp, 0.dp, 10.dp, 0.dp),
                onClick = {
                    // Handle Edit account button click
                    viewModel.incrementButtonClickCount()
                }
            ) {
                Text(text = "Edit Account",
                    color = Color.White)
            }
        }

        Design()
    }
}
@Composable
fun ProfilePicture(
    profilePictureUrl: String?,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape
) {
    if (profilePictureUrl != null) {
        // Load profile picture from URL using Coil
        Image(
            painter = rememberImagePainter(data = profilePictureUrl),
            contentDescription = "Profile Picture",
            modifier = modifier.size(120.dp),
            contentScale = ContentScale.Crop,

        )
    } else {
        // If profile picture URL is null, show a placeholder
        Image(
            painter = painterResource(id = R.drawable.placeholder_image),
            contentDescription = "Placeholder",
            modifier = modifier.size(120.dp),
            contentScale = ContentScale.Crop,
        )
    }
}


@Composable
@Preview(showBackground = true)
fun ProfilePagePreview() {
    ProfilePageContent(User.ProfilePageViewModel())
}