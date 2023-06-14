package com.example.proandroid

import android.app.Application
import com.example.proandroid.di.viewModelModule
import com.example.repository.di.databaseModule
import com.example.repository.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(retrofitModule, viewModelModule, databaseModule)
        }
    }
}