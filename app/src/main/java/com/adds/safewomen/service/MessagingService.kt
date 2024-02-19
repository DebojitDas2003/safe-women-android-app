package com.adds.safewomen.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.telephony.SmsManager
import android.util.Log
import androidx.room.Room
import com.adds.safewomen.database.ContactDatabase
import com.adds.safewomen.service.LocationService.Companion.TAG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class MessagingService : Service() {
    private lateinit var db: ContactDatabase

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contacts.db"
        ).build()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                db.dao.getAllContactsByPhoneNumber().collect { contactList ->
                    val jobs = contactList.map { contact ->
                        async {
                            sendMessage(contact.phoneNumber, "Your message here")
                        }
                    }
                    jobs.awaitAll()
                }
            } catch (e: Exception) {
                // Handle exceptions, log or notify the user
            } finally {
                db.close()
                stopSelf()
            }
        }

        return START_NOT_STICKY
    }

    private fun sendMessage(phoneNumber: String, message: String) {
        try {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
            Log.d(TAG, "Message sent successfully to $phoneNumber")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to send message to $phoneNumber: ${e.message}")
            // Handle the exception accordingly, such as logging or showing a notification to the user
        }
    }


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::db.isInitialized && db.isOpen) {
            db.close()
        }
    }
}
