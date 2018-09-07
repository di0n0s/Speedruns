package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class AssetsResponseDto(val logo: AssetResponseDto?,
                             @SerializedName("cover-tiny") val coverTiny: AssetResponseDto?,
                             @SerializedName("cover-small") val coverSmall: AssetResponseDto?,
                             @SerializedName("cover-medium") val coverMedium: AssetResponseDto?,
                             @SerializedName("cover-large") val coverLarge: AssetResponseDto?,
                             val icon: AssetResponseDto?,
                             @SerializedName("trophy-1st") val firstTrophy: AssetResponseDto?,
                             @SerializedName("trophy-2nd") val secondTrophy: AssetResponseDto?,
                             @SerializedName("trophy-3rd") val thirdTrophy: AssetResponseDto?,
                             @SerializedName("trophy-4th") val fourthTrophy: AssetResponseDto?,
                             val background: AssetResponseDto?,
                             val foreground: AssetResponseDto?)