package com.example.sfuentes.speedruns.entities

import android.os.Parcel
import android.os.Parcelable

data class GameView(var id: String = "",
                    var name: String = "",
                    var logo: String = "",
                    var speedRunVideoUrl: String = "",
                    var playerName: String = "",
                    var speedRunTime: String = "") : BaseGameView(), Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(name)
        writeString(logo)
        writeString(speedRunVideoUrl)
        writeString(playerName)
        writeString(speedRunTime)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<GameView> = object : Parcelable.Creator<GameView> {
            override fun createFromParcel(source: Parcel): GameView = GameView(source)
            override fun newArray(size: Int): Array<GameView?> = arrayOfNulls(size)
        }
    }
}