package com.adds.safewomen.viewmodel

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.telephony.SmsManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomePageViewModel : ViewModel() {

    fun onSOSButtonClicked(context: Context, phoneNumber: String, message: String) {
        viewModelScope.launch {
            sendSMS(context, phoneNumber, message)
            sendWhatsAppMessage(context, phoneNumber, message)
        }
    }

    private fun sendSMS(context: Context, phoneNumber: String, message: String) {
        try {
            val smsManager: SmsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun sendWhatsAppMessage(context: Context, phoneNumber: String, message: String) {
        try {
            val uri = Uri.parse("smsto:$phoneNumber")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.setPackage("com.whatsapp")
            intent.putExtra("sms_body", message)
            context.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
