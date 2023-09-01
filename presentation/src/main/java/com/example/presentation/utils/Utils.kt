package com.example.presentation.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).fitCenter().centerCrop().into(this)
}