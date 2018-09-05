package com.example.data.repository.datasource

import com.example.data.entities.GameListResponseDto
import io.reactivex.Observable

interface DataStore {

    fun getGameList(offset: Int): Observable<GameListResponseDto>
}