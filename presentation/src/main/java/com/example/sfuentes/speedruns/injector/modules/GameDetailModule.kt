package com.example.sfuentes.speedruns.injector.modules

import com.example.sfuentes.speedruns.injector.PerFragment
import com.example.sfuentes.speedruns.views.gameDetail.GameDetailFragment
import com.example.sfuentes.speedruns.views.gameDetail.GameDetailView
import dagger.Module
import dagger.Provides

@Module
class GameDetailModule(private val gameDetailFragment: GameDetailFragment) {

    @Provides
    @PerFragment
    fun provideGameDetailView(): GameDetailView = gameDetailFragment
}