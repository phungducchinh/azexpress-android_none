package com.azer.core

import android.app.Application
import com.azer.core.data.local.AppDatabase
import com.azer.core.di.localModule
import com.azer.core.di.remoteModule
import com.azer.core.di.repositoryModule
import com.azer.core.di.roomModule
import com.azer.core.model.User
import com.azer.core.util.PrefUtil
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

open class CoreApplication : Application() {

    val db : AppDatabase by inject()

    companion object {
        lateinit var instance: CoreApplication
            private set
    }

    private val prefsUtil: PrefUtil by inject()

    private var user: User? = null

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CoreApplication)
            modules(getModule())
        }

        instance = this
        user = prefsUtil.user
    }

    fun isNetworkConnected(): Boolean {
        return prefsUtil.isNetworkConnected()
    }

    private fun getModule(): List<Module> {
        val moduleList = arrayListOf<Module>()
        moduleList.addAll(listOf(remoteModule, repositoryModule, localModule, roomModule))
        moduleList.addAll(addModules())
        return moduleList
    }

    open fun addModules(): List<Module> = emptyList()

    fun saveUser(user: User?) {
        prefsUtil.user = user
        this.user = user
    }

    fun getUser(): User? = user
}