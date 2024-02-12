package com.adds.safewomen.view


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adds.safewomen.viewmodel.User
import com.example.compose.Background
import com.example.compose.Design
import com.example.safewomen.R
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.compose.Background
import com.example.compose.Design
//import com.adds.safewomen.viewmodel.User.Companion.DEFAULT_ADDRESS
//import com.adds.safewomen.viewmodel.User.Companion.DEFAULT_NAME
//import com.adds.safewomen.viewmodel.User.Companion.DEFAULT_WORKPLACE
//import com.adds.safewomen.viewmodel.User.Companion.ID
//import com.adds.safewomen.viewmodel.User.Companion.PROFILE_PICTURE_URL
import com.adds.safewomen.viewmodel.User.ProfilePageViewModel

val Typography.h6: TextStyle
    @Composable
    get() = h6.copy(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Cyan // Or any color you prefer
    )

val Typography.body1: TextStyle
    @Composable
    get() = body1.copy(
        fontWeight = FontWeight.Bold,
        color = Color.Blue // Adjust color as needed
    )
class ProfilePage : ComponentActivity() {
    private val viewModel: User.ProfilePageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilePageContent(viewModel)
        }
    }
}
@Composable
fun ProfilePageContent(viewModel: User.ProfilePageViewModel) {
    val userState = viewModel.user.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val user = userState.value // Retrieve the user from the observed state
        user.let { user ->
            Image(
                painter = painterResource(id = R.drawable.profile_placeholder),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = user.name,
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = user.workplace,
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = user.address,
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Simulating update of user data
                val updatedUser = User(
                    id = user.ID,
                    name = "Jane Doe",
                    workplace = "Updated Company",
                    address = "456 Second St",
                    profilePictureUrl = user.PROFILE_PICTURE_URL
                )
                onUpdateUser(updatedUser)
            }) {
                Text(text = "Update Profile")
            }
        }
        Design()
    }

}

}

fun onUpdateUser(updatedUser: User) {
    TODO("Not yet implemented")
}

@Composable
@Preview(showBackground = false)
fun ProfilePagePreview() {
    ProfilePageContent(User.ProfilePageViewModel())
}
