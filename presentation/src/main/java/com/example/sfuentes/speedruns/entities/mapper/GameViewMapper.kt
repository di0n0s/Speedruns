package com.example.sfuentes.speedruns.entities.mapper

import android.content.Context
import com.example.domain.model.Game
import com.example.sfuentes.speedruns.R
import com.example.sfuentes.speedruns.entities.GameView

object GameViewMapper {

    fun toView(game: Game, gameView: GameView, context: Context): GameView {
        setPlayerName(game, gameView, context)
        setRunTime(game, gameView, context)
        setVideoUrl(game, gameView)
        return gameView
    }

    private fun setPlayerName(game: Game, gameView: GameView, context: Context) {
        if (game.playerName.isNotBlank())
            gameView.playerName = game.playerName
        else
            gameView.playerName = context.getString(R.string.commons_unknown)
    }

    private fun setRunTime(game: Game, gameView: GameView, context: Context) {
        if (game.speedRunTime.isNotBlank())
            gameView.speedRunTime = game.speedRunTime
        else
            gameView.speedRunTime = context.getString(R.string.commons_unknown)
    }

    private fun setVideoUrl(game: Game, gameView: GameView) {
        gameView.speedRunVideoUrl = game.speedRunVideoUrl
    }


}