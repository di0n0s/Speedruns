package com.example.sfuentes.speedruns.presenters.gameDetail

import com.example.sfuentes.speedruns.entities.GameView
import com.example.sfuentes.speedruns.presenters.base.BaseApiPresenter

interface GameDetailPresenter : BaseApiPresenter {

    fun getGameDetail(gameId : Int)
    fun setModel(gameView: GameView)
}