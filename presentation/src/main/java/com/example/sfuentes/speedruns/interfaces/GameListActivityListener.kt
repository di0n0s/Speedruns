package com.example.sfuentes.speedruns.interfaces

import android.view.View
import com.example.sfuentes.speedruns.entities.GameView

interface GameListActivityListener {

    fun goToGameDetailActivity(gameView: GameView, view: View)
}