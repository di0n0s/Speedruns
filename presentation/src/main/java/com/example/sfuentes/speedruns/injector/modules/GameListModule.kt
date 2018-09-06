package com.example.sfuentes.speedruns.injector.modules

import com.example.sfuentes.speedruns.injector.PerFragment
import com.example.sfuentes.speedruns.views.gameList.GameListActivity
import com.example.sfuentes.speedruns.views.gameList.GameListFragment
import com.example.sfuentes.speedruns.views.gameList.GameListVew
import dagger.Module
import dagger.Provides

@Module
class GameListModule (private val gameListFragment: GameListFragment,
                      private val gameListActivity: GameListActivity) {
    @Provides
    @PerFragment
    fun provideGameListView(): GameListVew {
        return gameListFragment
    }

}