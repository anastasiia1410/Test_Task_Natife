package com.example.domain.repository

import com.example.data.network.NetworkManager
import com.example.domain.entity.Data
import com.example.domain.mapper.toData

class GifsRepositoryImpl(private val networkManager: NetworkManager) : GifsRepository {
    override suspend fun getGifs(): Data {
        return networkManager.getGifs().toData()
    }


}