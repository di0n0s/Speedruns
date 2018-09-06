package com.example.sfuentes.speedruns.views.gameDetail


import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.sfuentes.speedruns.R
import com.example.sfuentes.speedruns.entities.GameView
import com.example.sfuentes.speedruns.views.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 *
 */
class GameDetailFragment : BaseFragment() {

    companion object {
        const val TAG = "GameDetailFragment"
        private const val ARG_GAME = "ArgGame"

        fun newInstance(gameView: GameView): GameDetailFragment {
            val args = Bundle()
            val fragment = GameDetailFragment()
            args.putParcelable(ARG_GAME, gameView)
            fragment.arguments = args
            return fragment
        }
    }

    override fun layoutId(): Int = R.layout.fragment_game_detail

    override fun setupFragmentComponent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
