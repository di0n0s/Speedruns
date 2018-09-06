package com.example.sfuentes.speedruns

import android.app.Application
import com.example.sfuentes.speedruns.injector.components.ApplicationComponent
import com.example.sfuentes.speedruns.injector.components.DaggerApplicationComponent
import com.example.sfuentes.speedruns.injector.modules.ApplicationModule

class SpeedrunApplication : Application() {

    companion object {
        lateinit var instance: SpeedrunApplication
        @JvmStatic
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initializeInjector()
    }

    private fun initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()

    }

}