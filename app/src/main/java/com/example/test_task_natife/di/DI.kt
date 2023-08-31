package com.example.test_task_natife.di

import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.presentation.di.presentationModule
import com.example.test_task_natife.App
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun App.initKoin(){
    startKoin {
        androidContext(this@initKoin)
        modules(presentationModule, domainModule, dataModule)
    }
}