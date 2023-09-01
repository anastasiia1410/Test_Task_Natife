package com.example.data.network

import com.example.data.network.entity.DataNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("trending")
    suspend fun getGifs(
        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int,
    ): DataNetwork
}