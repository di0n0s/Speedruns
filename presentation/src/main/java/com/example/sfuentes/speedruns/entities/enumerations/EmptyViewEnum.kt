package com.example.sfuentes.speedruns.entities.enumerations

import com.example.sfuentes.speedruns.R

enum class EmptyViewEnum(var imageId: Int, var title: Int, var subtitle: Int) {
    EMPTY_GAME_LIST(R.drawable.ic_movie_placeholder, R.string.game_list_empty_title, R.string.game_list_empty_subtitle)
}