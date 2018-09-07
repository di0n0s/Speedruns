package com.example.sfuentes.speedruns.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.sfuentes.speedruns.R
import com.example.sfuentes.speedruns.entities.GameView
import com.example.sfuentes.speedruns.views.gameDetail.GameDetailActivity
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Navigator @Inject constructor() {

    fun toGameDetail(context: Context?, gameView: GameView, view: View) {
        if (context != null) {
            val intentToLaunch = GameDetailActivity.getCallingIntent(context, gameView)
            context.startActivity(intentToLaunch, prepareOptionsToBundle(context, view))
        }
    }

    fun toVideo(uri: String, context: Context?) {
        if (context != null) {
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            context.startActivity(webIntent)
        }
    }

    private fun prepareOptionsToBundle(context: Context?, view: android.view.View): Bundle? {
        val transitionName = context?.getString(R.string.game_transition_poster)
        val options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(context as AppCompatActivity, view, transitionName!!)
        return options.toBundle()
    }

}