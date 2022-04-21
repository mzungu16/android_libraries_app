package com.gleb.android_libraries_app.data.allUsersRepo.retrofit

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RetrofitInt {
    @GET("users")
    fun getUsers(): Single<List<UsersPojo>>
}