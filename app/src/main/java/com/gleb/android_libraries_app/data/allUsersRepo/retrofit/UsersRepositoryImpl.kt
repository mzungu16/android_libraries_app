package com.gleb.android_libraries_app.data.allUsersRepo.retrofit

import android.util.Log
import com.gleb.android_libraries_app.domain.Repository
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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


    override fun observeUsers(): Single<List<UsersPojo>> {
        return Single.create { singleEmitter ->
            val call = api.getUsers()
            call.enqueue(object : Callback<List<UsersPojo>> {
                override fun onResponse(
                    call: Call<List<UsersPojo>>,
                    response: Response<List<UsersPojo>>
                ) {
                    response.body()?.let {
                        singleEmitter.onSuccess(it)
                    }
                }
                override fun onFailure(call: Call<List<UsersPojo>>, t: Throwable) {
                    Log.d("TAG", t.stackTraceToString())
                }
            })
        }
    }
}