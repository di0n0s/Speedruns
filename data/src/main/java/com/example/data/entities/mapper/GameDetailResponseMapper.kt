package com.example.data.entities.mapper

import com.example.data.entities.RecordListResponseDto
import com.example.data.entities.RecordResponseDto
import com.example.domain.model.Game

object GameDetailResponseMapper {

    fun toBo(recordListResponseDto: RecordListResponseDto?): Game {
        val game = Game()
        if (recordListResponseDto != null) {
            val data = recordListResponseDto.data
            if (data != null && data.isNotEmpty()) {
                setGameValues(game, data)
            }
        }
        return Game()
    }

    private fun setGameValues(game: Game, data: List<RecordResponseDto>) {
        game.playerName = data[0].runs?.get(0)?.run?.players?.get(0)?.id ?: ""
        game.speedRunTime = data[0].runs?.get(0)?.run?.times?.primary ?: ""
        game.speedRunVideoUrl = data[0].runs?.get(0)?.run?.videos?.links?.get(0)?.uri ?: ""
    }
}