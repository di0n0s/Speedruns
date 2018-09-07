package com.example.data.net

import com.example.data.entities.GameListResponseDto
import com.example.data.entities.RecordListResponseDto
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("games")
    fun getGameList(@Query("offset") offset: Int): Observable<GameListResponseDto>

    @GET("games/{game}/records")
    fun getGameDetail(@Path("game") gameId : String,
                      @Query("miscellaneous") miscellaneous : Boolean,
                      @Query("top") top : Int) : Observable<RecordListResponseDto>
}