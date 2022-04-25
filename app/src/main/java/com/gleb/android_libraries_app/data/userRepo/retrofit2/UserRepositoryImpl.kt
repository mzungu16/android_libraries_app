package com.gleb.android_libraries_app.data.userRepo

import androidx.lifecycle.MutableLiveData
import com.gleb.android_libraries_app.data.userRepo.retrofit2.ReposPojo
import com.gleb.android_libraries_app.data.userRepo.retrofit2.UserRetrofitInt
import com.gleb.android_libraries_app.domain.Repository
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UserRepositoryImpl : Repository.UserRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api: UserRetrofitInt = retrofit.create(UserRetrofitInt::class.java)

    override fun observeUsersRepo(userName: String): Single<List<ReposPojo>> =
        api.getRepos(userName)

}
