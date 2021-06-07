package com.example.mvvmexample

import android.app.Application
import org.koin.android.ext.android.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
        startKoin(applicationContext, myNetworkModule)
    }
}