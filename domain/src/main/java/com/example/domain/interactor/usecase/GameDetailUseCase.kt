package com.example.domain.interactor.usecase

import com.example.domain.executor.PostExecutionThread
import com.example.domain.interactor.params.GameDetailParams
import com.example.domain.interactor.params.Params
import com.example.domain.model.Game
import com.example.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class GameDetailUseCase @Inject constructor(private val repository: Repository, postExecutionThread: PostExecutionThread)
    : BaseUseCase<Game>(postExecutionThread = postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Observable<Game> =
            repository.getGameDetail((params as GameDetailParams).gameId)


}