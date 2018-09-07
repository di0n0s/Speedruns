package com.example.sfuentes.speedruns.injector.components

import com.example.sfuentes.speedruns.injector.modules.*
import com.example.sfuentes.speedruns.views.base.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ApiModule::class])
interface ApplicationComponent {

    fun inject(baseActivity: BaseActivity)

    fun plus(baseListModule: BaseListModule, gameListModule: GameListModule) : GameListComponent

    fun plus(gameDetailModule: GameDetailModule) : GameDetailComponent

}