package com.adds.safewomen.service

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.telephony.SmsManager
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.room.Room
import com.adds.safewomen.MainActivity
import com.adds.safewomen.database.ContactDatabase
import com.example.safewomen.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class MessagingService : Service() {
    private lateinit var db: ContactDatabase
    private var lastLocation: Location? = null
    private val handler = Handler(Looper.getMainLooper())
    private var isFirstMessage = true

    private val locationManager by lazy {
        getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            if (lastLocation == null || location.distanceTo(lastLocation!!) > 0) {
                lastLocation = location
                val latitude = location.latitude
                val longitude = location.longitude
                val googleMapsLink = "http://maps.google.com/maps?q=$latitude,$longitude"
                val distressMessage = "Help! I'm in danger!! My current location is: $googleMapsLink"
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
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Messaging Service")
            .setContentText("Service is running background")
            .setSmallIcon(R.mipmap.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contacts.db"
        ).build()

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0f, locationListener)
        }

        return START_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Messaging Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }

    private fun sendMessage(phoneNumber: String, message: String) {
        val runnable = Runnable {
            try {
                SmsManager.getDefault().sendTextMessage(phoneNumber, null, message, null, null)
                isFirstMessage = false
            } catch (e: Exception) {
                Log.e(TAG, "Failed to send SMS", e)
            }
        }

        if (isFirstMessage) {
            handler.post(runnable)
        } else {
            handler.postDelayed(runnable, 30000)  // Delay of 30 seconds
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

    companion object {
        const val CHANNEL_ID = "MessagingServiceChannel"
    }
}
