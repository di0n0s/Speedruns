package com.example.data.repository.datasource

import com.example.data.entities.GameListResponseDto
import com.example.data.entities.RecordListResponseDto
import io.reactivex.Observable

interface DataStore {

    fun getGameList(offset: Int): Observable<GameListResponseDto>

    fun getGameDetail(gameId : String) : Observable<RecordListResponseDto>
}