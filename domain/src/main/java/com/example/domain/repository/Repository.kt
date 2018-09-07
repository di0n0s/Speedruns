package com.example.domain.repository

import com.example.domain.model.Game
import com.example.domain.model.GameListPagination
import io.reactivex.Observable

interface Repository {

    fun getGameList(offset: Int): Observable<GameListPagination>

    fun getGameDetail(gameId: String): Observable<Game>
}