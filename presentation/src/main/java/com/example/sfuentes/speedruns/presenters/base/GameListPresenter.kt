package com.example.sfuentes.speedruns.presenters.base

import com.example.domain.model.GameListPagination

interface GameListPresenter<T> : BaseListPresenter<T> {

    fun onGameListReceived(gameListPagination: GameListPagination)
}