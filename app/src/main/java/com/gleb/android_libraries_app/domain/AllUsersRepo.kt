package com.gleb.android_libraries_app.domain

import androidx.lifecycle.LiveData
import com.gleb.android_libraries_app.data.allUsersRepo.Users

interface AllUsersRepo {

    interface Repository {
        fun getAllUsersLiveData(): LiveData<List<Users>>
        fun getInternetAccess()
    }
}