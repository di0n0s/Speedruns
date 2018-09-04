package com.example.sfuentes.speedruns

import android.app.Application

class SpeedrunApplication : Application() {

    companion object {
        lateinit var instance: SpeedrunApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initializeInjector()
    }

    private fun initializeInjector() {
    }

}