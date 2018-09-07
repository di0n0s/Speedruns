package com.example.domain.model

data class Game(val id : String = "",
                val name : String = "",
                val logo : String = "",
                var speedRunVideoUrl : String = "",
                var playerName : String = "",
                var speedRunTime : String = "")