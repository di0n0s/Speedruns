package com.example.domain.model

data class GameListPagination(var nextOffset: Int? = null,
                              var gameList: List<Game> = ArrayList())