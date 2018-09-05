package com.example.data.net

import com.example.data.entities.GameListResponseDto
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("games")
    fun getGameList(@Query("offset") offset: Int): Observable<GameListResponseDto>
}