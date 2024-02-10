package com.adds.safewomen.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AboutScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Image(
            painter = painterResource(id = R.drawable.bg_1),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(top = 16.dp, start = 16.dp, bottom = 16.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 50.dp,
                        topEnd = 0.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 50.dp
                    )
                )
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF2D01FE),
                            Color(
                                0xFF8E3DFD
                            )
                        )
                    ),
                    shape = RoundedCornerShape(topStart = 30.dp, bottomEnd = 30.dp)
                )
                .padding(40.dp)
        ) {


            Text(
                text = "Version 1.0.0",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary,
                letterSpacing = (2).sp,
            )

            Text(
                text = "Welcome to a self-awareness " +
                        "App specially created for women " +
                        "to ensure their safety",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onSecondary,
                lineHeight = 24.sp,
                modifier = Modifier
                    .padding(top = 8.dp),
                letterSpacing = (3).sp
            )

            Spacer(modifier = Modifier.height(30.dp))


            val cornerRadius = 16.dp
            val gradientColor = listOf(Color(0xFF000000), Color(0xFF292B42))

            GradientButton(
                gradientColors = gradientColor,
                cornerRadius = cornerRadius,
                nameButton = "Developed by- " +
                              "Team ADDS",
                roundedCornerShape = RoundedCornerShape(topStart = 30.dp,bottomEnd = 30.dp)
            )
        }
    }
}

@Composable
private fun GradientButton(
    gradientColors: List<Color>,
    cornerRadius: Dp,
    nameButton: String,
    roundedCornerShape: RoundedCornerShape
) {

    androidx.compose.material3.Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        onClick = {
            //your code
        },

        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(cornerRadius)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(colors = gradientColors),
                    shape = roundedCornerShape
                )
                .clip(roundedCornerShape)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = nameButton,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSecondary,
                letterSpacing = (2).sp,
            )
        }
    }
}