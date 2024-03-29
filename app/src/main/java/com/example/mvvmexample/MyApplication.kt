package com.example.mvvmexample

import android.app.Application
import com.example.mvvmexample.di.myDiModule
import org.koin.android.ext.android.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
    }
}