package com.example.antonio.weatherapp.ui

import android.app.Application
import com.example.antonio.weatherapp.extensions.DelegatesExt

/**
 * Created by antonio on 24/05/17.
 */

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}