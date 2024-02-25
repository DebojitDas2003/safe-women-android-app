package com.adds.safewomen.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PermissionDialog(
    permissionTextProvider: PermissionTextProvider,
    isPermanentlyDeclined:Boolean,
    onDismiss: ()->Unit,
    onOkClick: ()->Unit,
    onGoToAppSettingsClick :()-> Unit,
    modifier: Modifier =Modifier
)

    {

        CustomAlertDialog(
            onDismissRequest = onDismiss,
            buttons = {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Divider()
                    Text(text = if (isPermanentlyDeclined) {
                        "Grant permission"
                    } else {
                        "Ok"
                    },
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                if (isPermanentlyDeclined) {
                                    onGoToAppSettingsClick()
                                } else {
                                    onOkClick()
                                }
                            }
                            .padding(16.dp)
                    )
                }
            },
            title = {
                Text(text = "Permission required")
            },
            text = {
                Text(
                    text = permissionTextProvider.getDescription(
                        isPermanentlyDeclined = isPermanentlyDeclined
                    )
                )
            },
            modifier = modifier
        )
    }

fun CustomAlertDialog(onDismissRequest: () -> Unit, buttons: @Composable () -> Unit,
    title: @Composable () -> Unit, text: @Composable () -> Unit, modifier: Modifier
) {}


interface PermissionTextProvider{
    fun getDescription(isPermanentlyDeclined: Boolean):String
}

class CameraPermissionTextProvider: PermissionTextProvider{
    override fun getDescription(isPermanentlyDeclined: Boolean): String {
        return if(isPermanentlyDeclined){
            "It seems you permanently declined camera permission." +
                    "You can go to the app settings to grant it"
        }else{
            "This app needs access to your camera "
        }
    }
}

class RecordAudioPermissionTextProvider: PermissionTextProvider{
    override fun getDescription(isPermanentlyDeclined: Boolean): String {
        return if(isPermanentlyDeclined){
            "It seems you permanently declined microphone permission." +
                    "You can go to the app settings to grant it"
        }else{
            "This app needs access to your microphone "
        }
    }
}

class PhoneCallPermissionTextProvider: PermissionTextProvider{
    override fun getDescription(isPermanentlyDeclined: Boolean): String {
        return if(isPermanentlyDeclined){
            "It seems you permanently declined phone calling  permission." +
                    "You can go to the app settings to grant it"
        }else{
            "This app needs access to phone calling permission "
        }
    }
}

class LocationPermissionTextProvider: PermissionTextProvider{
    override fun getDescription(isPermanentlyDeclined: Boolean): String {
        return if(isPermanentlyDeclined){
            "It seems you permanently declined location access permission." +
                    "You can go to the app settings to grant it"
        }else{
            "This app needs access to location permission "
        }
    }
}