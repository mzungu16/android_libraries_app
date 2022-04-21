package com.gleb.android_libraries_app

import android.app.Application
import android.content.Context
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersRepositoryImpl
import com.gleb.android_libraries_app.data.userRepo.UserRepositoryImpl
//import com.gleb.android_libraries_app.data.userRepo.RepositoryImplUser
import com.gleb.android_libraries_app.domain.Repository

class App : Application() {
    val usersRepo: Repository.UsersRepository by lazy { UsersRepositoryImpl() }
    val userRepo: Repository.UserRepository by lazy { UserRepositoryImpl() }
}

val Context.app: App
    get() {
        return applicationContext as App
    }