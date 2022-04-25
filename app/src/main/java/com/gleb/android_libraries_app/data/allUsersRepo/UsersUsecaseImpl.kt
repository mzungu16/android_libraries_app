package com.gleb.android_libraries_app.data.allUsersRepo

import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersRepositoryImpl
import com.gleb.android_libraries_app.domain.ProjectUsecase

class UsersUsecaseImpl(private val api: UsersRepositoryImpl) : ProjectUsecase.UsersUsecase {
    override val data: UsersRepositoryImpl
        get() = api
}