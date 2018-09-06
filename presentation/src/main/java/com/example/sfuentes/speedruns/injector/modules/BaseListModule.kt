package com.example.sfuentes.speedruns.injector.modules

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import com.example.sfuentes.speedruns.injector.PerFragment
import dagger.Provides

class BaseListModule (private val context: Context){

    @Provides
    @PerFragment
    fun provideGridLayoutManager(): GridLayoutManager = GridLayoutManager(context, 3)

}