package com.example.sfuentes.speedruns

import com.example.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UIThread @Inject constructor() : PostExecutionThread {

    override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()

}