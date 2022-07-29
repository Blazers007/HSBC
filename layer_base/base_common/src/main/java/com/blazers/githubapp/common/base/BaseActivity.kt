package com.blazers.githubapp.common.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding>(
    private val inflateMethod: (LayoutInflater) -> T
) : AppCompatActivity() {

    val viewBinding by lazy { inflateMethod(layoutInflater) }

    abstract fun onCreate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        onCreate()
    }
}