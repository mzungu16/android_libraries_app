package com.gleb.android_libraries_app.domain

import androidx.lifecycle.LiveData
import com.gleb.android_libraries_app.data.allUsersRepo.Users
import com.gleb.android_libraries_app.data.userRepo.Repos

interface AllUsersRepo {

    interface Repository {
        fun getAllUsersLiveData(): LiveData<List<Users>>
        fun getInternetAccess()
    }

    interface RepositoryUser {
        fun getAllRepos(): LiveData<List<Repos>>
        fun getInternetAccess()
    }
}