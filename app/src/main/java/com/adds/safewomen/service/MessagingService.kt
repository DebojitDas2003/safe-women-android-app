package com.adds.safewomen.service

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.IBinder
import android.telephony.SmsManager
import android.widget.Toast



class MessagingService:Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Get the phone number and message (you can customize this part)
        val phoneNumber = "9734433986" // Replace with the actual recipient's number
        val message = "Emergency! Please help!"

        // Send SMS
        sendSMS(phoneNumber, message)

        // Send WhatsApp message
        sendWhatsAppMessage(phoneNumber, message)

        // Stop the service (optional)
        stopSelf()
        return START_NOT_STICKY
    }

    private fun sendSMS(phoneNumber: String, message: String) {
        val sentPI = PendingIntent.getBroadcast(this, 0, Intent("SMS_SENT"),
            PendingIntent.FLAG_IMMUTABLE)
        SmsManager.getDefault().sendTextMessage(phoneNumber, null, message, sentPI, null)
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun sendWhatsAppMessage(whatsappNumber: String, message: String) {
        val whatsappIntent = Intent(Intent.ACTION_VIEW)
        whatsappIntent.type = "text/plain"
        whatsappIntent.setPackage("com.whatsapp")
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, message)

        if (whatsappIntent.resolveActivity(packageManager) != null) {
            startActivity(whatsappIntent)
        } else {
            Toast.makeText(this, "Please install WhatsApp first.", Toast.LENGTH_SHORT).show()
            // Optionally, provide a link to download WhatsApp from the Play Store
            val playStoreUri = Uri.parse("market://details?id=com.whatsapp")
            val playStoreIntent = Intent(Intent.ACTION_VIEW, playStoreUri)
            startActivity(playStoreIntent)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
