package com.azer.core.di

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.azer.core.util.PrefUtil
import org.koin.dsl.module

const val PREFS_FILENAME = "com.sg.covid"

val localModule = module {
    single { Gson() }
    single { provideSharedPreference(get()) }
    single { providePreferenceHelper(get(), get(), get()) }
}

fun providePreferenceHelper(context: Context,
                            sharedPreferences: SharedPreferences, gSon: Gson) =
    PrefUtil(context, sharedPreferences, gSon)

fun provideSharedPreference(context: Context): SharedPreferences =
    context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)