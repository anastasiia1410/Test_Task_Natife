package com.example.data.network

import com.example.data.network.entity.DataNetwork
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManagerImpl : NetworkManager {
    private val gson: Gson
    private val client: OkHttpClient
    private val retrofit: Retrofit
    private val api: Api

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        gson = GsonBuilder().serializeNulls().create()
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.giphy.com/v1/gifs/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        api = retrofit.create(Api::class.java)
    }

    override suspend fun getGifs(): DataNetwork {
        return api.getGifs(API_KEY, LIMIT)
    }

    companion object {
        const val API_KEY = "QYwk8FxxgFCfcspE2UkMsxjeHTYOJ3cZ"
        const val LIMIT = 20
    }
}