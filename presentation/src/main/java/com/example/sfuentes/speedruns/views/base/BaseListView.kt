package com.example.sfuentes.speedruns.views.base

interface BaseListView : BaseView {

    fun showRecyclerView()
    fun hideRecyclerView()
    fun hideEmptyView()
    fun showEmptyView()
    fun setItems()
    fun setNullAdapter()
    fun setRefreshingBehaviour()
    fun setEmptyView()
}