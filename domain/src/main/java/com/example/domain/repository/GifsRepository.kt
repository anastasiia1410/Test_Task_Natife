package com.example.domain.repository

import com.example.domain.entity.Data

interface GifsRepository {
    suspend fun getGifs() : Data
}