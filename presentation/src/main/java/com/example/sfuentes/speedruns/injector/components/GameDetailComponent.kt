package com.example.sfuentes.speedruns.injector.components

import com.example.sfuentes.speedruns.injector.PerFragment
import com.example.sfuentes.speedruns.injector.modules.GameDetailModule
import com.example.sfuentes.speedruns.views.gameDetail.GameDetailFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [GameDetailModule::class])
interface GameDetailComponent {

    fun inject(gameDetailFragment: GameDetailFragment)
}