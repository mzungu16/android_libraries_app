package com.gleb.android_libraries_app

import android.app.Application
import android.content.Context
import com.gleb.android_libraries_app.data.allUsersRepo.RepositoryImpl

class App : Application() {
    val repo by lazy { RepositoryImpl() }
}

val Context.app: App
    get() {
        return applicationContext as App
    }