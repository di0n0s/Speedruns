package com.example.sfuentes.speedruns.injector.components

import com.example.sfuentes.speedruns.injector.modules.ApplicationModule
import com.example.sfuentes.speedruns.views.base.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(baseActivity: BaseActivity)

}