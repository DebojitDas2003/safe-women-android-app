package com.adds.safewomen.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adds.safewomen.viewmodel.homescreenwidgetViewModel

@Composable
fun HomeScreenWidget() {
    val viewModel: homescreenwidgetViewModel = viewModel()

}

@Composable
@Preview(showBackground = true)
fun PreviewHomeScreenWidget() {
    HomeScreenWidget()
}
