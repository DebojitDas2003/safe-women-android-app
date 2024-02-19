package com.adds.safewomen.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize


class HelpWidget: GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {


        provideContent {
            ContentView()
        }
    }

    @Composable
    private fun ContentView() {

        Column {
            Button(
                modifier = GlanceModifier
                    .fillMaxSize()
                ,
                text = "Help",
                onClick = { /*TODO*/ })


        }

    }

}