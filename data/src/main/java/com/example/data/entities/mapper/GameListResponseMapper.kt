package com.example.data.entities.mapper

import com.example.data.entities.GameListResponseDto
import com.example.data.net.ApiConstants
import com.example.domain.model.Game
import com.example.domain.model.GameListPagination

object GameListResponseMapper {

    fun toPaginationModel(gameListResponseDto: GameListResponseDto?): GameListPagination =
            GameListPagination(getNextOffSet(gameListResponseDto),
                    toBusinessObject(gameListResponseDto))

    private fun toBusinessObject(gameListResponseDto: GameListResponseDto?): List<Game> {
        val gameList = ArrayList<Game>()
        if (gameListResponseDto != null) {
            val data = gameListResponseDto.data
            if (data != null && data.isNotEmpty()) {
                data.forEach {
                    if (it.id != null && it.names?.international != null) {
                        gameList.add(Game(it.id,
                                it.names.international,
                                it.assets?.coverMedium?.uri ?: ""))
                    }
                }
            }
        }
        return gameList
    }

    private fun getNextOffSet(gameListResponseDto: GameListResponseDto?): Int? {
        gameListResponseDto?.pagination?.links?.forEach {
            if (it.rel == ApiConstants.NEXT) {
                return it.uri?.split("=")?.get(1)?.toInt()
            }
        }
        return null
    }
}