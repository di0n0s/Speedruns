package com.example.sfuentes.speedruns.presenters.base

interface BasePresenter {

    fun onStart()
    fun onResume()
    fun onPause()
    fun onDestroy()
}