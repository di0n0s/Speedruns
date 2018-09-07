package com.example.sfuentes.speedruns.observers

import com.example.domain.model.Game
import com.example.sfuentes.speedruns.observers.base.BaseObserver
import com.example.sfuentes.speedruns.presenters.gameDetail.GameDetailPresenterImpl

class GameDetailObserver(private val presenter: GameDetailPresenterImpl) : BaseObserver<Game>(presenter) {

    override fun onNext(t: Game) {
        presenter.onGameDetailReceived(t)
    }

}