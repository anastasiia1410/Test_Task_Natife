package com.example.data.network

import com.example.data.network.entity.DataNetwork

interface NetworkManager {
    suspend fun getGifs() : DataNetwork
}