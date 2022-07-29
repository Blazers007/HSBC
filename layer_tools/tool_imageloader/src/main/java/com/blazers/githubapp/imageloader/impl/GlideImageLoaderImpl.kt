package com.blazers.githubapp.imageloader.impl

import android.widget.ImageView
import com.blazers.githubapp.imageloader.ImageLoader
import com.bumptech.glide.Glide

class GlideImageLoaderImpl : ImageLoader.Loader {

    override fun load(imageView: ImageView, url: String, loadingPlaceholder: Int, errorPlaceholder: Int) {
        Glide.with(imageView)
            .load(url)
            .apply {
                loadingPlaceholder.takeIf { it > 0 }?.let { placeholder(it) }
                errorPlaceholder.takeIf { it > 0 }?.let { fallback(it) }
            }
            .into(imageView)
    }
}