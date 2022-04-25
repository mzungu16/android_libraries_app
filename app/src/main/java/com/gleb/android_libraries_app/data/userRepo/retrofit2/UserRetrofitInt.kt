package com.gleb.android_libraries_app.data.userRepo.retrofit2

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserRetrofitInt {
    @GET("users/{user}/repos")
    fun getRepos(
        @Path("user") user: String
    ): Single<List<ReposPojo>>
}