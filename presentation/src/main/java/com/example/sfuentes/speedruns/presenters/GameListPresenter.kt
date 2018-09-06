package com.example.sfuentes.speedruns.presenters

import com.example.domain.model.GameListPagination
import com.example.sfuentes.speedruns.presenters.base.BaseListPresenter

interface GameListPresenter<T> : BaseListPresenter<T> {

    fun onGameListReceived(gameListPagination: GameListPagination)
}