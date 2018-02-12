package com.mgilangjanuar.dev.weatherprediction.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 * @since 2018
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(findLayout())
    }

    abstract fun findLayout() : Int
}