package com.example.domain.di

import com.example.domain.repository.GifsRepository
import com.example.domain.repository.GifsRepositoryImpl
import org.koin.dsl.module

val domainModule = module {
    factory<GifsRepository> { GifsRepositoryImpl(get()) }
}