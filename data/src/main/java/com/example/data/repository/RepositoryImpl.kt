package com.example.data.repository

import com.example.data.entities.mapper.GameDetailResponseMapper
import com.example.data.entities.mapper.GameListResponseMapper
import com.example.data.repository.datasource.DataStore
import com.example.domain.model.Game
import com.example.domain.model.GameListPagination
import com.example.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val dataStore: DataStore) : Repository {

    override fun getGameList(offset: Int): Observable<GameListPagination> =
            dataStore.getGameList(offset).map { GameListResponseMapper.toPaginationModel(it) }

    override fun getGameDetail(gameId: String): Observable<Game> =
            dataStore.getGameDetail(gameId).map { GameDetailResponseMapper.toBo(it) }
}