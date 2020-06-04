package com.azer.azexpressandroid

import androidx.lifecycle.LifecycleObserver
import com.azer.azexpressandroid.di.appModules
import com.azer.core.CoreApplication
import org.koin.core.module.Module

class MainApplication : CoreApplication(), LifecycleObserver {

    companion object {
        lateinit var instance: MainApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun getInstance() = instance

    override fun addModules(): List<Module> {
        return listOf(appModules)
    }
}