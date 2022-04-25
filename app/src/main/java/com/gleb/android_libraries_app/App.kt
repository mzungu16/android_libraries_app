package com.gleb.android_libraries_app

import android.app.Application
import android.content.Context
import com.gleb.android_libraries_app.data.allUsersRepo.UsersUsecaseImpl
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersRepositoryImpl
import com.gleb.android_libraries_app.data.userRepo.UserRepositoryImpl
import com.gleb.android_libraries_app.data.userRepo.UserUsecaseImpl
import com.gleb.android_libraries_app.domain.ProjectUsecase

//import com.gleb.android_libraries_app.data.userRepo.RepositoryImplUser

class App : Application() {
    private val usersRepo by lazy { UsersRepositoryImpl() }
    private val userRepo by lazy { UserRepositoryImpl() }
    val usersUsecase: ProjectUsecase.UsersUsecase by lazy { UsersUsecaseImpl(usersRepo) }
    val userUsecase: ProjectUsecase.UserUsecase by lazy { UserUsecaseImpl(userRepo) }
}

val Context.app: App
    get() {
        return applicationContext as App
    }