package com.gleb.android_libraries_app.di

import com.gleb.android_libraries_app.data.allUsersRepo.UsersUsecaseImpl
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.RetrofitInt
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersRepositoryImpl
import com.gleb.android_libraries_app.data.userRepo.UserRepositoryImpl
import com.gleb.android_libraries_app.data.userRepo.UserUsecaseImpl
import com.gleb.android_libraries_app.data.userRepo.retrofit2.UserRetrofitInt
import com.gleb.android_libraries_app.domain.ProjectUsecase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DaggerModule {

    @Singleton
    @Provides
    fun provideRetrofitInt(retrofit: Retrofit): RetrofitInt {
        return retrofit.create(RetrofitInt::class.java)
    }

    @Singleton
    @Provides
    fun provideUserRetrofitInt(retrofit: Retrofit): UserRetrofitInt {
        return retrofit.create(UserRetrofitInt::class.java)
    }

    @Singleton
    @Provides
    fun provideUsersRepositoryImpl(retrofitInt: RetrofitInt): UsersRepositoryImpl {
        return UsersRepositoryImpl(retrofitInt)
    }

    @Singleton
    @Provides
    fun provideUserRepositoryImpl(userRetrofitInt: UserRetrofitInt): UserRepositoryImpl {
        return UserRepositoryImpl(userRetrofitInt)
    }

    @Singleton
    @Provides
    fun provideUsersUseCase(usersRepositoryImpl: UsersRepositoryImpl): ProjectUsecase.UsersUsecase {
        return UsersUsecaseImpl(usersRepositoryImpl)
    }

    @Singleton
    @Provides
    fun provideUserUseCase(userRepositoryImpl: UserRepositoryImpl): ProjectUsecase.UserUsecase {
        return UserUsecaseImpl(userRepositoryImpl)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}