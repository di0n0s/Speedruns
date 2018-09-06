package com.example.sfuentes.speedruns.presenters.base

interface BasePresenter {

    fun start()
    fun onResume()
    fun onPause()
    fun onDestroy()
}