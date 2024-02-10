package com.adds.safewomen.service


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.telephony.SmsManager

class MessagingService(private val context: Context) {
    fun sendSMS(phoneNumber: String, message: String) {
        val smsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(phoneNumber, null, message, null, null)
    }

    fun sendWhatsAppMessage(phoneNumber: String, message: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$phoneNumber&text=$message")
        context.startActivity(intent)
    }
}
