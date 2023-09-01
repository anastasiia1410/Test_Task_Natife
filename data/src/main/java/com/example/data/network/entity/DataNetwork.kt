package com.example.data.network.entity

import com.google.gson.annotations.SerializedName

data class DataNetwork(@SerializedName("data") val gifsList: List<GifNetwork>)

data class GifNetwork(val id: String, @SerializedName("images") val image: ImageNetwork)

data class ImageNetwork(
    @SerializedName("fixed_height_small")
    val fixedHeightSmallUrl: FixedHeightSmallUrlNet,
    @SerializedName("original")
    val originalUrl: OriginalUrlNet,
)

data class OriginalUrlNet(val url: String, val mp4: String)

data class FixedHeightSmallUrlNet(val url: String, val mp4: String)
