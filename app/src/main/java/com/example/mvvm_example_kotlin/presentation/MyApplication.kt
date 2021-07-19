package com.example.mvvm_example_kotlin.presentation

import android.app.Application
import com.example.mvvm_example_kotlin.di.modules
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
    }
}