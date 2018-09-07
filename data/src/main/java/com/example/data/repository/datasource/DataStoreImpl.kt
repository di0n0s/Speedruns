package com.example.data.repository.datasource

import com.example.data.entities.GameListResponseDto
import com.example.data.entities.RecordListResponseDto
import com.example.data.net.ApiConstants
import com.example.data.net.ApiService
import io.reactivex.Observable
import javax.inject.Inject

class DataStoreImpl @Inject constructor(private val apiService: ApiService) : DataStore {

    override fun getGameList(offset: Int): Observable<GameListResponseDto> = apiService.getGameList(offset)

    override fun getGameDetail(gameId: String): Observable<RecordListResponseDto> = apiService.getGameDetail(gameId, ApiConstants.MISCELLANEOUS, ApiConstants.TOP)
}