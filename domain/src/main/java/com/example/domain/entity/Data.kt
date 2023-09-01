package com.example.domain.entity

data class Data(val gifsList: List<Gif>)

data class Gif(val id: String, val image: Image)

data class Image(val fixedHeightSmallUrl: FixedHeightSmallUrl, val originalUrl: OriginalUrl)

data class OriginalUrl(val url: String, val mp4: String)

data class FixedHeightSmallUrl(val url: String, val mp4: String)

