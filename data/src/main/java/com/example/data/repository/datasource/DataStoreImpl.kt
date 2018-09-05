package com.example.data.repository.datasource

import com.example.data.entities.GameListResponseDto
import com.example.data.net.ApiService
import io.reactivex.Observable
import javax.inject.Inject

class DataStoreImpl @Inject constructor(private val apiService: ApiService) : DataStore {

    override fun getGameList(offset: Int): Observable<GameListResponseDto> = apiService.getGameList(offset)

}