package com.artushock.stopwatch.application

import android.app.Application
import com.artushock.stopwatch.di.appModule
import org.koin.core.context.startKoin

class StopwatchApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}