package com.gleb.android_libraries_app.di

import com.gleb.android_libraries_app.data.allUsersRepo.UsersUsecaseImpl
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.RetrofitInt
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersRepositoryImpl
import com.gleb.android_libraries_app.data.userRepo.UserRepositoryImpl
import com.gleb.android_libraries_app.data.userRepo.UserUsecaseImpl
import com.gleb.android_libraries_app.data.userRepo.retrofit2.UserRetrofitInt
import com.gleb.android_libraries_app.domain.ProjectUsecase
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    // single instance
//    single<GsonConverterFactory> { GsonConverterFactory.create() }
    single {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<RetrofitInt> { get<Retrofit>().create(RetrofitInt::class.java) }
    single<UserRetrofitInt> { get<Retrofit>().create(UserRetrofitInt::class.java) }

    single { UsersRepositoryImpl(get()) }
    single { UserRepositoryImpl(get()) }
    single<ProjectUsecase.UsersUsecase> { UsersUsecaseImpl(get()) }
    single<ProjectUsecase.UserUsecase> { UserUsecaseImpl(get()) }


}
/*

*/