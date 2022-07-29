package com.blazers.githubapp.imageloader.impl

import android.widget.ImageView
import com.blazers.githubapp.imageloader.ImageLoader
import com.squareup.picasso.Picasso

class PicassoImageLoaderImpl : ImageLoader.Loader {

    override fun load(imageView: ImageView, url: String, loadingPlaceholder: Int, errorPlaceholder: Int) {
        Picasso.get().load(url)
            .apply {
                loadingPlaceholder.takeIf { it > 0 }?.let { placeholder(it) }
                errorPlaceholder.takeIf { it > 0 }?.let { error(it) }
            }
            .into(imageView)
    }
}