package com.azer.core.di

import com.azer.core.data.local.AppDatabase
import org.koin.dsl.module

val roomModule = module {
    single { AppDatabase.getInstance(get()) }
    single { get<AppDatabase>().userDao() }
    single { get<AppDatabase>().messageDao()}
}