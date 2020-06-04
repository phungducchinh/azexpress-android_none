package com.azer.core.di

import com.azer.core.repository.AuthRepository
import com.azer.core.repository.impl.AuthRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get(), get(), get()) }
}