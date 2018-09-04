package com.example.sfuentes.speedruns.observers.base

import com.example.sfuentes.speedruns.presenters.base.BaseApiPresenter
import io.reactivex.observers.DisposableObserver

abstract class BaseObserver<T>(private val presenter: BaseApiPresenter) : DisposableObserver<T>() {

    override fun onComplete() {
    }

    override fun onError(e: Throwable) {
        presenter.onErrorReceived()
    }
}