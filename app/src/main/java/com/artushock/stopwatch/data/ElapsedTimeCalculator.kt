package com.artushock.stopwatch.data

import com.artushock.stopwatch.data.StopwatchState
import com.artushock.stopwatch.data.TimestampProvider

class ElapsedTimeCalculator(
    private val timestampProvider: TimestampProvider,
) {
    fun calculate(state: StopwatchState.Running): Long {

        val currentTimeStamp = timestampProvider.getMilliseconds()
        val timePassedSinceStart = if (currentTimeStamp > state.startTime) {
            currentTimeStamp - state.startTime
        } else {
            0
        }
        return timePassedSinceStart + state.elapsedTime
    }
}