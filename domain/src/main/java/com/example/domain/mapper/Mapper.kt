package com.example.domain.mapper

import com.example.data.network.entity.DataNetwork
import com.example.data.network.entity.FixedHeightSmallUrlNet
import com.example.data.network.entity.GifNetwork
import com.example.data.network.entity.ImageNetwork
import com.example.data.network.entity.OriginalUrlNet
import com.example.domain.entity.Data
import com.example.domain.entity.FixedHeightSmallUrl
import com.example.domain.entity.Gif
import com.example.domain.entity.Image
import com.example.domain.entity.OriginalUrl


fun ImageNetwork.toImage(): Image {
    return Image(
        fixedHeightSmallUrl = this.fixedHeightSmallUrl.toFixedHeightSmallUrl(),
        originalUrl = this.originalUrl.toOriginalUrl()
    )
}

fun GifNetwork.toGif(): Gif {
    return Gif(
        id = this.id,
        image = this.image.toImage()
    )
}

fun DataNetwork.toData(): Data {
    return Data(gifsList = this.gifsList.map { it.toGif() })
}

fun FixedHeightSmallUrlNet.toFixedHeightSmallUrl(): FixedHeightSmallUrl {
    return FixedHeightSmallUrl(
        url = this.url,
        mp4 = this.mp4
    )
}

fun OriginalUrlNet.toOriginalUrl(): OriginalUrl {
    return OriginalUrl(
        url = this.url,
        mp4 = this.mp4
    )
}



