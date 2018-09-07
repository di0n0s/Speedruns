package com.example.sfuentes.speedruns.presenters.base

interface BaseListPresenter<T> : BaseApiPresenter {

    fun loadData()
    fun loadEndlessData()
    fun setIsLastPage(nextOffset: Int?)
    fun addFooter()
    var model: ArrayList<T>
    var offset: Int
    var isLoading: Boolean
    var isLastPage: Boolean
}