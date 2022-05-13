package com.gleb.android_libraries_app

import android.app.Application
import android.content.Context
import com.gleb.android_libraries_app.di.DaggerComponent
import com.gleb.android_libraries_app.di.DaggerDaggerComponent

class App : Application() {
    lateinit var daggerComponent: DaggerComponent
    override fun onCreate() {
        super.onCreate()
        daggerComponent = DaggerDaggerComponent
            .builder()
            .build()
    }
}

val Context.app: App
    get() {
        return applicationContext as App
    }