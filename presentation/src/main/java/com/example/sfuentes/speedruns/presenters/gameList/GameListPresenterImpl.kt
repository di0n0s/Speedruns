package com.example.sfuentes.speedruns.presenters.gameList

import com.example.domain.interactor.params.GameListParams
import com.example.domain.interactor.usecase.GameListUseCase
import com.example.domain.model.GameListPagination
import com.example.sfuentes.speedruns.entities.BaseGameView
import com.example.sfuentes.speedruns.entities.FooterGameView
import com.example.sfuentes.speedruns.entities.GameListPaginationView
import com.example.sfuentes.speedruns.entities.mapper.GameListPaginationViewMapper
import com.example.sfuentes.speedruns.injector.PerFragment
import com.example.sfuentes.speedruns.observers.GameListObserver
import com.example.sfuentes.speedruns.views.gameList.GameListView
import javax.inject.Inject

@PerFragment
class GameListPresenterImpl @Inject constructor(private val gameListUseCase: GameListUseCase) : GameListPresenter<BaseGameView> {

    override var model: ArrayList<BaseGameView> = ArrayList()
    override var isLoading: Boolean = false
    override var isLastPage: Boolean = false
    override var offset: Int = 0
    private var loadEndlessData: Boolean = false
    @Inject
    lateinit var view: GameListView

    private fun getGameList() {
        gameListUseCase.execute(GameListParams(offset), GameListObserver(this))
    }

    override fun onGameListReceived(gameListPagination: GameListPagination) {
        val gameListPaginationView = GameListPaginationViewMapper.turnInto(gameListPagination)
        if (!loadEndlessData) {
            model = gameListPaginationView.gameList
            setIsLastPage(gameListPaginationView.nextOffset)
            addFooter()
        } else
            removeFooterAndConcat(gameListPaginationView)
        manageViewAfterOK()
    }

    override fun loadData() {
        setOffsetZero()
        setLoadEndlessDataFalse()
        getGameList()
    }

    private fun setLoadEndlessDataFalse() {
        loadEndlessData = false
    }

    private fun setOffsetZero() {
        offset = 0
    }


    override fun loadEndlessData() {
        loadEndlessData = true
        getGameList()
    }

    override fun setIsLastPage(nextOffset: Int?) {
        if (nextOffset == null) {
            isLastPage = true
        } else {
            offset = nextOffset
            isLastPage = false
        }

    }

    override fun addFooter() {
        if (!isLastPage)
            model.add(FooterGameView())
    }

    override fun onErrorReceived() {
        view.showEmptyView()
        view.hideRecyclerView()
        view.showProgressBar(false)
        view.showErrorMessage()
    }

    override fun start() {
        loadData()
    }

    override fun onResume() {}

    override fun onPause() {}

    override fun onDestroy() {
        gameListUseCase.dispose()
    }

    private fun removeFooterAndConcat(gameListPaginationView: GameListPaginationView) {
        model.removeAll { it is FooterGameView }
        model.addAll(gameListPaginationView.gameList)
        if (gameListPaginationView.nextOffset != null) {
            offset = gameListPaginationView.nextOffset!!
            addFooter()
        } else
            isLastPage = true
    }

    private fun manageViewAfterOK() {
        restartAdapter()
        view.setItems()
        showOrHideEmptyAndRecyclerView()
        isLoading = false
        view.showProgressBar(false)
    }

    private fun restartAdapter() {
        if (!loadEndlessData)
            view.setNullAdapter()
    }

    private fun showOrHideEmptyAndRecyclerView() {
        if (model.isEmpty()) {
            view.showEmptyView()
            view.hideRecyclerView()
        } else {
            view.showRecyclerView()
            view.hideEmptyView()
        }
    }

}