package com.example.sfuentes.speedruns.injector.modules

import com.example.sfuentes.speedruns.injector.PerFragment
import com.example.sfuentes.speedruns.interfaces.GameListActivityListener
import com.example.sfuentes.speedruns.views.gameList.GameListActivity
import com.example.sfuentes.speedruns.views.gameList.GameListFragment
import com.example.sfuentes.speedruns.views.gameList.GameListVew
import dagger.Module
import dagger.Provides

@Module
class GameListModule(private val gameListFragment: GameListFragment,
                     private val gameListActivity: GameListActivity) {
    @Provides
    @PerFragment
    fun provideGameListView(): GameListVew = gameListFragment

    @Provides
    @PerFragment
    fun provideGameListActivityListener(): GameListActivityListener = gameListActivity
}