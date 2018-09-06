package com.example.sfuentes.speedruns.views.gameList


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.sfuentes.speedruns.R
import com.example.sfuentes.speedruns.SpeedrunApplication
import com.example.sfuentes.speedruns.adapters.GameListAdapter
import com.example.sfuentes.speedruns.entities.BaseGameView
import com.example.sfuentes.speedruns.entities.GameView
import com.example.sfuentes.speedruns.entities.enumerations.EmptyViewEnum
import com.example.sfuentes.speedruns.injector.modules.BaseListModule
import com.example.sfuentes.speedruns.injector.modules.GameListModule
import com.example.sfuentes.speedruns.interfaces.AdapterListOnClickListener
import com.example.sfuentes.speedruns.interfaces.GameListActivityListener
import com.example.sfuentes.speedruns.presenters.gameList.GameListPresenterImpl
import com.example.sfuentes.speedruns.views.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_game_list.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class GameListFragment : BaseFragment(), GameListView, AdapterListOnClickListener.ViewListener {

    @Inject
    lateinit var presenter: GameListPresenterImpl
    @Inject
    lateinit var layoutManager: GridLayoutManager
    @Inject
    lateinit var activityListener: GameListActivityListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setEmptyView()
        setRefreshingBehaviour()
        setSpanSize()
        presenter.start()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        setNullAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgressBar(show: Boolean) {
        if (swipeRefreshLayout.isRefreshing) {
            if (!show)
                swipeRefreshLayout.isRefreshing = false
        }
    }

    override fun showRecyclerView() {
        gameListRecyclerView.visibility = View.VISIBLE
    }

    override fun hideRecyclerView() {
        gameListRecyclerView.visibility = View.GONE
    }

    override fun hideEmptyView() {
        emptyView.visibility = View.GONE
    }

    override fun showEmptyView() {
        emptyView.visibility = View.VISIBLE
    }

    override fun setItems() {
        setAdapter(presenter.model)
    }

    override fun setNullAdapter() {
        gameListRecyclerView.adapter = null
    }

    override fun setRefreshingBehaviour() {
        swipeRefreshLayout.setOnRefreshListener {
            presenter.isLoading = true
            restartLastPosition()
            presenter.start()
        }
    }

    private fun restartLastPosition() {
        (gameListRecyclerView.adapter as GameListAdapter).restartLastPosition()
    }


    override fun setEmptyView() {
        emptyView.fillViews(EmptyViewEnum.EMPTY_GAME_LIST)
    }

    override fun showErrorMessage() {
        showToastMessage(getString(R.string.api_error))
    }

    override fun layoutId(): Int = R.layout.fragment_game_list

    override fun setupFragmentComponent() {
        SpeedrunApplication
                .applicationComponent
                .plus(BaseListModule(this.context!!),
                        GameListModule(this, activity as GameListActivity))
                .inject(this)
    }

    override fun onItemSelected(position: Int, view: View) {
        activityListener.goToGameDetailActivity(presenter.model[position] as GameView, view)
    }

    private fun setRecyclerView() {
        setLayoutManager()
        setScrollListener()
    }

    private fun setAdapter(model: List<BaseGameView>) {
        initAdapter(model)
        notifyDataSetChanged()
    }

    private fun notifyDataSetChanged() {
        gameListRecyclerView.adapter.notifyDataSetChanged()
    }

    private fun initAdapter(model: List<BaseGameView>) {
        if (gameListRecyclerView.adapter == null)
            gameListRecyclerView.adapter = GameListAdapter(model, this)
    }

    private fun setScrollListener() {
        gameListRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy > 0) {
                    val lastItem = layoutManager.findLastCompletelyVisibleItemPosition()
                    val currentTotalCount = layoutManager.itemCount
                    //6 elements before to call endless data
                    if (currentTotalCount <= lastItem + 6) {
                        if (!presenter.isLastPage && !presenter.isLoading) {
                            presenter.isLoading = true
                            presenter.loadEndlessData()
                        }
                    }
                }
            }
        })
    }

    private fun setLayoutManager() {
        gameListRecyclerView.layoutManager = layoutManager
    }

    private fun setSpanSize() {
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val adapter = gameListRecyclerView.adapter
                return when (adapter.getItemViewType(position)) {
                    GameListAdapter.GAME_TYPE -> 1
                    GameListAdapter.FOOTER_TYPE -> 3
                    else -> -1
                }
            }

        }
    }
}
