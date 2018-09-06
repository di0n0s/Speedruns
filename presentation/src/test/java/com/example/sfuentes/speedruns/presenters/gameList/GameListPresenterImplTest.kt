package com.example.sfuentes.speedruns.presenters.gameList

import com.example.domain.interactor.usecase.GameListUseCase
import com.example.sfuentes.speedruns.UnitTest
import com.example.sfuentes.speedruns.entities.BaseGameView
import com.example.sfuentes.speedruns.views.gameList.GameListView
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class GameListPresenterImplTest : UnitTest() {

    private lateinit var presenter: GameListPresenterImpl
    @Mock
    private lateinit var useCase: GameListUseCase
    @Mock
    private lateinit var view: GameListView
    @Mock
    private lateinit var model: ArrayList<BaseGameView>

    @Before
    fun setup() {
        presenter = GameListPresenterImpl(useCase)
        initView()
    }

    private fun initView() {
        presenter.view = view
    }

    @Test
    fun loadDataTest() {
        presenter.loadData()

        assert(presenter.offset == 0)
        verify(useCase).execute(any(), any())
    }

    @Test
    fun loadEndlessDataTest() {
        presenter.loadEndlessData()
        verify(useCase).execute(any(), any())
    }

    @Test
    fun setIsLastPageTrueTest() {
        presenter.setIsLastPage(null)
        assert(presenter.isLastPage)
    }

    @Test
    fun setIsLastPageFalseTest() {
        presenter.setIsLastPage(20)
        assert(!presenter.isLastPage)
    }

    @Test
    fun addFooterFalseTest() {
        presenter.isLastPage = true

        presenter.addFooter()

        verify(model, never()).add(any())
    }

}