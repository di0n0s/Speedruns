package com.example.sfuentes.speedruns.views.gameList

import android.os.Bundle
import com.example.sfuentes.speedruns.R
import com.example.sfuentes.speedruns.views.base.BaseActivity
import com.example.sfuentes.speedruns.views.base.BaseFragment
import kotlinx.android.synthetic.main.activity_base.*

class GameListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbarTitle()
    }

    override fun fragment(): BaseFragment = GameListFragment()

    override fun setToolbarTitle() {
        toolbar.title = getString(R.string.game_list_toolbar_title)
    }
}
