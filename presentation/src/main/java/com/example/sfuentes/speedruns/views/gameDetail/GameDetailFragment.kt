package com.example.sfuentes.speedruns.views.gameDetail


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.sfuentes.speedruns.R
import com.example.sfuentes.speedruns.SpeedrunApplication
import com.example.sfuentes.speedruns.entities.GameView
import com.example.sfuentes.speedruns.injector.modules.GameDetailModule
import com.example.sfuentes.speedruns.interfaces.GameDetailActivityListener
import com.example.sfuentes.speedruns.presenters.gameDetail.GameDetailPresenterImpl
import com.example.sfuentes.speedruns.views.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_game_detail.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class GameDetailFragment : BaseFragment(), GameDetailView {

    @Inject
    lateinit var presenter : GameDetailPresenterImpl
    @Inject
    lateinit var activityListener : GameDetailActivityListener

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonListener()
        presenter.setModel(arguments?.getParcelable(ARG_GAME)!!)
        presenter.start()
    }

    override fun layoutId(): Int = R.layout.fragment_game_detail

    override fun setupFragmentComponent() {
        SpeedrunApplication
                .applicationComponent
                .plus(GameDetailModule(this, activity as GameDetailActivity))
                .inject(this)
    }

    override fun showProgressBar(show: Boolean) {
        //TODO progressBar.visibility = View.GONE -- View.VISIBLE
    }

    override fun showErrorMessage() {
        showToastMessage(getString(R.string.api_error))
    }

    override fun setView() {
        playerNameTextView.text = presenter.gameView.playerName
        runTimeTextView.text = presenter.gameView.speedRunTime
    }

    override fun showButton() {
        videoButton.visibility = View.VISIBLE
    }

    override fun hideButtton() {
        videoButton.visibility = View.GONE
    }

    private fun setButtonListener(){
        videoButton.setOnClickListener {
            activityListener.goToVideo(presenter.gameView.speedRunVideoUrl)
        }
    }


}
