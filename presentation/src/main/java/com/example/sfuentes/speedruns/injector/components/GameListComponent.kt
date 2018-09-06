package com.example.sfuentes.speedruns.injector.components

import com.example.sfuentes.speedruns.injector.PerFragment
import com.example.sfuentes.speedruns.injector.modules.BaseListModule
import com.example.sfuentes.speedruns.injector.modules.GameListModule
import com.example.sfuentes.speedruns.views.gameList.GameListFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [BaseListModule::class, GameListModule::class])
interface GameListComponent {

    fun inject(gameListFragment: GameListFragment)
}