package com.blazers.githubapp.imageloader

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.blazers.githubapp.imageloader.impl.PicassoImageLoaderImpl

object ImageLoader {

    private var loader: Loader = PicassoImageLoaderImpl()

    private var defaultLoadingImagePlaceholder: Int = 0
    private var defaultErrorImagePlaceholder: Int = 0

    fun configLoader(loader: Loader) {
        this.loader = loader
    }

    fun configDefaultPlaceholder(
        @DrawableRes loading: Int,
        @DrawableRes error: Int
    ) {
        defaultLoadingImagePlaceholder = loading
        defaultErrorImagePlaceholder = error
    }

    fun load(
        imageView: ImageView,
        url: String,
        @DrawableRes loadingPlaceholder: Int = defaultLoadingImagePlaceholder,
        @DrawableRes errorPlaceholder: Int = defaultErrorImagePlaceholder
    ) {
        loader.load(imageView, url, loadingPlaceholder, errorPlaceholder)
    }

    interface Loader {
        fun load(
            imageView: ImageView,
            url: String,
            loadingPlaceholder: Int,
            errorPlaceholder: Int
        )
    }
}