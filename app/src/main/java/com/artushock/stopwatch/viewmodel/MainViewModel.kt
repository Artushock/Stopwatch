package com.artushock.stopwatch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.artushock.stopwatch.data.StopwatchListOrchestrator

class MainViewModel(
    private val stopWatcherOrchestrator: StopwatchListOrchestrator,
) : ViewModel() {

    val liveData = stopWatcherOrchestrator.ticker.asLiveData()

    fun start() {
        stopWatcherOrchestrator.start()
    }

    fun pause() {
        stopWatcherOrchestrator.pause()
    }

    fun stop() {
        stopWatcherOrchestrator.stop()
    }

}