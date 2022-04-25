package com.gleb.android_libraries_app.data.userRepo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersPojo
import com.gleb.android_libraries_app.data.userRepo.retrofit2.ReposPojo
import com.gleb.android_libraries_app.data.userRepo.retrofit2.UserRetrofitInt
import com.gleb.android_libraries_app.domain.Repository
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    override fun observeUsersRepo(userName: String): Single<List<ReposPojo>> {
        return Single.create { singleEmitter ->
            val call = api.getRepos(userName)
            call.enqueue(object : Callback<List<ReposPojo>> {
                override fun onResponse(
                    call: Call<List<ReposPojo>>,
                    response: Response<List<ReposPojo>>
                ) {
                    response.body()?.let {
                        singleEmitter.onSuccess(it)
                    }
                }

                override fun onFailure(call: Call<List<ReposPojo>>, t: Throwable) {
                    Log.d("TAG", t.stackTraceToString())
                }

            })
        }
    }

}
