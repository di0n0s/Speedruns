package com.example.sfuentes.speedruns.views.gameDetail

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.example.sfuentes.speedruns.R
import com.example.sfuentes.speedruns.entities.GameView
import com.example.sfuentes.speedruns.glide.GlideApp
import com.example.sfuentes.speedruns.views.base.BaseActivity
import com.example.sfuentes.speedruns.views.base.BaseFragment
import kotlinx.android.synthetic.main.activity_game_detail.*

class GameDetailActivity : BaseActivity() {

    private lateinit var gameView: GameView

    companion object {
        private const val EXTRA_GAME = "ExtraGame"

        fun getCallingIntent(context: Context, gameView: GameView): Intent {
            val callingIntent = Intent(context, GameDetailActivity::class.java)
            callingIntent.putExtra(EXTRA_GAME, gameView)
            return callingIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityTransitions()
        setContentView(R.layout.activity_game_detail)
        setToolbarTitle()
        setToolbarImage()
        initSupportActionBar()
    }

    override fun fragment(): BaseFragment = GameDetailFragment.newInstance(getGameExtra())

    private fun getGameExtra(): GameView {
        gameView = intent.getParcelableExtra(EXTRA_GAME)
        return gameView
    }

    override fun setToolbarTitle() {
        collapsingToolbar.title = gameView.name
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initSupportActionBar() {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
    }

    private fun initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val transition = Slide()
            transition.excludeTarget(android.R.id.statusBarBackground, true)
            window.enterTransition = transition
            window.returnTransition = transition
        }
    }

    private fun setToolbarImage() {
        if (gameView.logo != "") {
            GlideApp.with(this)
                    .load(gameView.logo)
                    .apply(RequestOptions().centerInside())
                    .apply(RequestOptions().placeholder(R.drawable.ic_movie_placeholder))
                    .into(gameBackdrop as ImageView)
        }
    }
}
