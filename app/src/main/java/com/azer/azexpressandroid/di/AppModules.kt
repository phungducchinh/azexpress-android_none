package com.azer.azexpressandroid.di

import com.azer.azexpressandroid.viewmodel.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    viewModel {
        AuthViewModel(get())
    }
}