package com.adds.safewomen.viewmodel.contactViewModel

import android.app.Application
import com.adds.safewomen.database.AppContainer
import com.adds.safewomen.database.AppDataContainer

class ContactListApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
