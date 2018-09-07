package com.example.data.net

object ApiConstants {

    private const val BASE_URL = "https://www.speedrun.com/api"
    const val ENDPOINT = "$BASE_URL/v1/"
    const val TIMEOUT_CONNECTION_VALUE = 60L
    const val TIMEOUT_READ_VALUE = 60L
    const val TIMEOUT_WRITE_VALUE = 60L
    const val NEXT = "next"
    const val TOP = 1
    const val MISCELLANEOUS = false
}