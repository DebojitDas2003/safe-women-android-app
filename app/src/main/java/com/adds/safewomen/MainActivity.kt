package com.adds.safewomen

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adds.safewomen.view.BottomNavBar
import com.adds.safewomen.viewmodel.BottomNavBarViewModel


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: BottomNavBarViewModel = viewModel()
            BottomNavBar(viewModel)

        }
    }
}




@Composable
@Preview()
fun AppPreview() {
    val viewModel = BottomNavBarViewModel()
    BottomNavBar(viewModel)
}