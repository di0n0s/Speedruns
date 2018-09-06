package com.example.sfuentes.speedruns.presenters.gameDetail

import com.example.sfuentes.speedruns.entities.GameView

class GameDetailPresenterImpl : GameDetailPresenter {

    lateinit var gameView: GameView

    override fun getGameDetail(gameId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setModel(gameView: GameView) {
        this.gameView = gameView
    }

    override fun onErrorReceived() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}