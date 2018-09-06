package com.example.domain.interactor.usecase

import com.example.domain.UnitTest
import com.example.domain.executor.PostExecutionThread
import com.example.domain.interactor.params.GameListParams
import com.example.domain.repository.Repository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class GameListUseCaseTest : UnitTest() {

    private lateinit var useCase: GameListUseCase
    @Mock
    private lateinit var repository: Repository
    @Mock
    private lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        useCase = GameListUseCase(repository, postExecutionThread)
    }

    @Test
    fun buildUseCaseObservableTest() {
        useCase.buildUseCaseObservable(GameListParams(23))

        verify(repository).getGameList(any())
    }
}