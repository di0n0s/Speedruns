package com.example.data.entities

data class RunInformationResponseDto(val videos : VideoResponseDto?,
                                     val players : List<PlayerResponseDto>?,
                                     val times : TimeResponseDto?)