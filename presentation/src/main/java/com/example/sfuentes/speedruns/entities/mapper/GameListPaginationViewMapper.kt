package com.example.sfuentes.speedruns.entities.mapper

import com.example.domain.model.Game
import com.example.domain.model.GameListPagination
import com.example.sfuentes.speedruns.entities.BaseGameView
import com.example.sfuentes.speedruns.entities.GameListPaginationView
import com.example.sfuentes.speedruns.entities.GameView

object GameListPaginationViewMapper {

    fun turnInto(gameListPagination: GameListPagination) : GameListPaginationView =
            GameListPaginationView(gameListPagination.nextOffset,
                    toListView(gameListPagination.gameList))

    private fun toView(game: Game) : GameView =
            GameView(game.id,
                    game.name,
                    game.logo,
                    game.speedRunVideoUrl,
                    game.playerName,
                    game.speedRunTime)

    private fun toListView(gameList : List<Game>) : ArrayList<BaseGameView>{
        val gameListView = ArrayList<BaseGameView>()
        if (gameList.isNotEmpty()){
            gameList.forEach {
                gameListView.add(toView(it))
            }
        }
        return gameListView
    }
}