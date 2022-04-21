package com.gleb.android_libraries_app.domain

import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersPojo
import com.gleb.android_libraries_app.data.userRepo.retrofit2.ReposPojo
import io.reactivex.rxjava3.core.Single

interface Repository {
    interface UsersRepository {
        fun observeUsers(): Single<List<UsersPojo>>
    }

    interface UserRepository {
        fun observeUsersRepo(userName: String): Single<List<ReposPojo>>
    }
}