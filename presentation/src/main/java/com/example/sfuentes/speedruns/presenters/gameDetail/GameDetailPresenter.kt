package com.example.sfuentes.speedruns.presenters.gameDetail

import com.example.domain.model.Game
import com.example.sfuentes.speedruns.entities.GameView
import com.example.sfuentes.speedruns.presenters.base.BaseApiPresenter

interface GameDetailPresenter : BaseApiPresenter {

    fun setModel(gameView: GameView)
    fun onGameDetailReceived(game: Game)
}