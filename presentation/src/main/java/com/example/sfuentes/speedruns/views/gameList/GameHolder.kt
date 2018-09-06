package com.example.sfuentes.speedruns.views.gameList

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.example.sfuentes.speedruns.R
import com.example.sfuentes.speedruns.entities.GameView
import com.example.sfuentes.speedruns.glide.GlideApp
import com.example.sfuentes.speedruns.interfaces.AdapterListOnClickListener
import kotlinx.android.synthetic.main.list_item_game.view.*

class GameHolder(itemView: View?, private val adapterListener: AdapterListOnClickListener.AdapterListener) : RecyclerView.ViewHolder(itemView) {

    fun bindGame(game: GameView) {
        setPoster(game)
        itemView.setOnClickListener { adapterListener.onItemSelected(adapterPosition, itemView) }
    }

    private fun setPoster(game: GameView) {
        if (game.logo != "") {
            GlideApp.with(itemView.context)
                    .load(game.logo)
                    .apply(RequestOptions().centerInside())
                    .apply(RequestOptions().placeholder(R.drawable.ic_movie_placeholder))
                    .into(itemView.gamePoster as ImageView)
        }
    }
}