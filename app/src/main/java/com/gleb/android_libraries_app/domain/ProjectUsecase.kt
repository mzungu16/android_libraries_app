package com.gleb.android_libraries_app.domain

import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersRepositoryImpl
import com.gleb.android_libraries_app.data.userRepo.UserRepositoryImpl

interface ProjectUsecase {

    interface UsersUsecase {
        val data : UsersRepositoryImpl
    }

    interface UserUsecase {
        val data: UserRepositoryImpl
    }

}