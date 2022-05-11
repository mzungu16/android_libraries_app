package com.gleb.android_libraries_app.data.allUsersRepo.retrofit

import android.util.Log
import com.gleb.android_libraries_app.domain.Repository
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersRepositoryImpl(private val api: RetrofitInt) : Repository.UsersRepository {
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