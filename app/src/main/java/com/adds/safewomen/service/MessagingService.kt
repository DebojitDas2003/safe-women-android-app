package com.adds.safewomen.service

import android.Manifest
import android.app.Service
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.IBinder
import android.telephony.SmsManager
import android.util.Log
import androidx.room.Room
import com.adds.safewomen.database.ContactDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class MessagingService : Service() {
    private lateinit var db: ContactDatabase

    private val locationManager by lazy {
        getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            val latitude = location.latitude
            val longitude = location.longitude
            val distressMessage = "Help! My current location is: Latitude = $latitude, Longitude = $longitude"

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    db.dao.getAllContactsByPhoneNumber().collect { contactList ->
                        val jobs = contactList.map { contact ->
                            async {
                                sendMessage(contact.phoneNumber, distressMessage)
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
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contacts.db"
        ).build()

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0f, locationListener)
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
        locationManager.removeUpdates(locationListener)
    }
}
