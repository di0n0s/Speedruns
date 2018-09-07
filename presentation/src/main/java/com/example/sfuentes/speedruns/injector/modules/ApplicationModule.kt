package com.example.sfuentes.speedruns.injector.modules

import android.content.Context
import com.example.sfuentes.speedruns.SpeedrunApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: SpeedrunApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Context = application
}