package com.gleb.android_libraries_app.data.allUsersRepo.retrofit

import com.gleb.android_libraries_app.domain.Repository
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UsersRepositoryImpl : Repository.UsersRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: RetrofitInt = retrofit.create(RetrofitInt::class.java)

    override fun observeUsers(): Single<List<UsersPojo>> = api.getUsers()
}