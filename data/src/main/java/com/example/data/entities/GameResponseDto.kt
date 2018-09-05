package com.example.data.entities

data class GameResponseDto (val id : String?,
                            val names : NameResponseDto?,
                            val abbreviation : String?,
                            val weblink : String?,
                            val released : Int?,
                            val ruleset : RulesetResponseDto?,
                            val romhack : Boolean?,
                            val gametypes : List<Any>?,
                            val platforms : List<String>?,
                            val regions : List<String>?,
                            val renges : List<String>?,
                            val engines : List<Any>?,
                            val developers : List<Any>?,
                            val publishers : List<Any>?,
                            val moderators : ModeratorResponseDto?,
                            val created : String?,
                            val assets : AssetsResponseDto?,
                            val links : List<LinkResponseDto>?)