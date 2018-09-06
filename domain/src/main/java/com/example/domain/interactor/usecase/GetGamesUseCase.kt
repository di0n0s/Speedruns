package com.example.domain.interactor.usecase

import com.example.domain.executor.PostExecutionThread
import com.example.domain.interactor.params.GamesParams
import com.example.domain.interactor.params.Params
import com.example.domain.model.GameListPagination
import com.example.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val repository: Repository, postExecutionThread: PostExecutionThread)
    : BaseUseCase<GameListPagination>(postExecutionThread = postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Observable<GameListPagination> =
        repository.getGameList((params as GamesParams).offset)

}