package com.example.sfuentes.speedruns.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.sfuentes.speedruns.R
import com.example.sfuentes.speedruns.entities.BaseGameView
import com.example.sfuentes.speedruns.entities.GameView
import com.example.sfuentes.speedruns.interfaces.AdapterListOnClickListener
import com.example.sfuentes.speedruns.views.gameList.GameFooterHolder
import com.example.sfuentes.speedruns.views.gameList.GameHolder

class GameListAdapter(private val gameList: List<BaseGameView>,
                      private val viewListener: AdapterListOnClickListener.ViewListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), AdapterListOnClickListener.AdapterListener {

    private var lastPosition = -1

    companion object {
        const val GAME_TYPE = 1
        const val FOOTER_TYPE = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            GAME_TYPE ->
                GameHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_game, parent, false), this)
            else -> {
                GameFooterHolder(LayoutInflater.from(parent.context).inflate(R.layout.generic_footer, parent, false))
            }
        }

    override fun getItemCount(): Int = gameList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GameHolder -> holder.bindGame(gameList[position] as GameView)
            is GameFooterHolder -> holder.bindProgressBar()
        }
        setAnimation(holder.itemView, position)
    }

    override fun getItemViewType(position: Int): Int =
            when (gameList[position]) {
                is GameView -> GAME_TYPE
                else -> FOOTER_TYPE
            }

    override fun onItemSelected(position: Int, view: View) {
        viewListener.onItemSelected(position, view)
    }

    fun restartLastPosition() {
        lastPosition = -1
    }

    @SuppressLint("PrivateResource")
    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(viewToAnimate.context, R.anim.abc_slide_in_bottom)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }
}