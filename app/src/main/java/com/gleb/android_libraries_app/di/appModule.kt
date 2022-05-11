package com.gleb.android_libraries_app.di

import com.gleb.android_libraries_app.data.allUsersRepo.UsersUsecaseImpl
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersRepositoryImpl
import com.gleb.android_libraries_app.data.userRepo.UserRepositoryImpl
import com.gleb.android_libraries_app.data.userRepo.UserUsecaseImpl
import com.gleb.android_libraries_app.domain.ProjectUsecase
import org.koin.dsl.module

val appModule = module {

    // single instance
    single { UsersRepositoryImpl() }
    single { UserRepositoryImpl() }
    single<ProjectUsecase.UsersUsecase> { UsersUsecaseImpl(get()) }
    single<ProjectUsecase.UserUsecase> { UserUsecaseImpl(get()) }

}
