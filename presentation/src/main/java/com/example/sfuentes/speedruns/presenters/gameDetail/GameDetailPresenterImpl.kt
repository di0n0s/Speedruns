package com.example.sfuentes.speedruns.presenters.gameDetail

import android.content.Context
import com.example.domain.interactor.params.GameDetailParams
import com.example.domain.interactor.usecase.GameDetailUseCase
import com.example.domain.model.Game
import com.example.sfuentes.speedruns.entities.GameView
import com.example.sfuentes.speedruns.entities.mapper.GameViewMapper
import com.example.sfuentes.speedruns.observers.GameDetailObserver
import com.example.sfuentes.speedruns.views.gameDetail.GameDetailView
import javax.inject.Inject

class GameDetailPresenterImpl(private val gameDetailUseCase: GameDetailUseCase) : GameDetailPresenter {

    @Inject
    lateinit var context: Context
    @Inject
    lateinit var view : GameDetailView
    lateinit var gameView: GameView


    private fun getGameDetail() {
        view.showProgressBar(true)
        gameDetailUseCase.execute(GameDetailParams(gameView.id), GameDetailObserver(this))
    }

    override fun setModel(gameView: GameView) {
        this.gameView = gameView
    }

    override fun onGameDetailReceived(game: Game) {
        setGameView(game)
        view.setView()
        setVideoButtonVisibility()
        view.showProgressBar(false)
    }

    private fun setVideoButtonVisibility() {
        if (gameView.speedRunVideoUrl.isNotBlank())
            view.showButton()
        else
            view.hideButtton()
    }

    private fun setGameView(game: Game) {
        gameView = GameViewMapper.toView(game, gameView, context)
    }

    override fun onErrorReceived() {
        view.showProgressBar(false)
        view.showErrorMessage()
    }

    override fun start() {
        getGameDetail()
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onDestroy() {
        gameDetailUseCase.dispose()
    }
}