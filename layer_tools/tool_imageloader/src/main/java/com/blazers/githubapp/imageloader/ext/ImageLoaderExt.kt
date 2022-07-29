package com.blazers.githubapp.imageloader.ext

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.blazers.githubapp.imageloader.ImageLoader

fun ImageView?.loadImage(
    url: String?,
    @DrawableRes loadingPlaceholder: Int = 0,
    @DrawableRes errorPlaceholder: Int = 0
) {
    if (this == null || url.isNullOrEmpty()) {
        return
    }
    ImageLoader.load(this, url, loadingPlaceholder, errorPlaceholder)
}