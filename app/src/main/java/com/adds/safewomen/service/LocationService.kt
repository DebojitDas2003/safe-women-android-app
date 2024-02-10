package com.adds.safewomen.service


import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class LocationService(private val activity: Activity) {
    private val fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity)

    fun getCurrentLocation(callback: (String) -> Unit) {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request location permission
            callback("Location permission not granted")
            return
        }

        val locationResult = fusedLocationClient.lastLocation
        locationResult.addOnCompleteListener(activity) { task ->
            if (task.isSuccessful && task.result != null) {
                val location = task.result
                // Return the location as a string
                callback("${location.latitude}, ${location.longitude}")
            } else {
                callback("Location not available")
            }
        }
    }
}
