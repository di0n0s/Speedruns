package com.example.sfuentes.speedruns.entities

data class GameListPaginationView (var nextOffset: Int? = null,
                                   var gameList: ArrayList<BaseGameView> = ArrayList())