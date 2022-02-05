package com.artushock.stopwatch.di

import com.artushock.stopwatch.data.*
import com.artushock.stopwatch.utils.TimestampMillisecondsFormatter
import com.artushock.stopwatch.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {


    factory<TimestampProvider> {
        object : TimestampProvider {
            override fun getMilliseconds(): Long {
                return System.currentTimeMillis()
            }
        }
    }

    factory { ElapsedTimeCalculator(get()) }

    factory { StopwatchStateCalculator(get(), get()) }

    factory { TimestampMillisecondsFormatter() }

    factory { StopwatchStateHolder(get(), get(), get()) }

    factory {
        StopwatchListOrchestrator(get(), CoroutineScope(
            Dispatchers.Main
                    + SupervisorJob())
        )
    }

    viewModel { MainViewModel(get()) }
}

