package com.gleb.android_libraries_app.data.userRepo

import com.gleb.android_libraries_app.domain.ProjectUsecase

class UserUsecaseImpl(private val api: UserRepositoryImpl) : ProjectUsecase.UserUsecase {
    override val data: UserRepositoryImpl
        get() = api
}