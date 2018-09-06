package com.example.sfuentes.speedruns.presenters.base

interface BaseListPresenter<T> : BaseApiPresenter {

    fun loadData()
    fun loadEndlessData()
    fun setIsLastPage(nextOffset: Int?)
    fun addFooter()
    var model: ArrayList<T>
    var isLoading: Boolean
    var page: Int
    var isLastPage: Boolean
}