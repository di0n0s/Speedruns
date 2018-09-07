package com.example.sfuentes.speedruns.observers

import com.example.domain.model.GameListPagination
import com.example.sfuentes.speedruns.observers.base.BaseObserver
import com.example.sfuentes.speedruns.presenters.gameList.GameListPresenterImpl

class GameListObserver(private val presenter: GameListPresenterImpl) : BaseObserver<GameListPagination>(presenter) {

    override fun onNext(t: GameListPagination) {
        presenter.onGameListReceived(t)
    }
}