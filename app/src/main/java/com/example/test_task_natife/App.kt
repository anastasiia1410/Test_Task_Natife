package com.example.test_task_natife

import android.app.Application
import com.example.test_task_natife.di.initKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}