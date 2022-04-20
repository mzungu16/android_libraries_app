package com.gleb.android_libraries_app.data.allUsersRepo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gleb.android_libraries_app.domain.AllUsersRepo

class RepositoryImpl : AllUsersRepo.Repository {
    private val liveDataToObserve: MutableLiveData<List<Users>> = MutableLiveData()
    private val listOfUsers = listOf(
        Users("login1", "https://i.pravatar.cc"),
        Users("login2", "https://i.pravatar.cc"),
        Users("login3", "https://i.pravatar.cc"),
        Users("login4", "https://i.pravatar.cc"),
        Users("login5", "https://i.pravatar.cc"),
        Users("login6", "https://i.pravatar.cc"),
        Users("login7", "https://i.pravatar.cc"),
        Users("login8", "https://i.pravatar.cc"),
        Users("login9", "https://i.pravatar.cc"),
        Users("login10", "https://i.pravatar.cc"),
        Users("login11", "https://i.pravatar.cc"),
        Users("login12", "https://i.pravatar.cc"),
        Users("login13", "https://i.pravatar.cc"),
        Users("login14", "https://i.pravatar.cc"),
        Users("login15", "https://i.pravatar.cc"),
        Users("login16", "https://i.pravatar.cc"),
    )

    override fun getAllUsersLiveData(): LiveData<List<Users>> {
        return liveDataToObserve
    }

    override fun getInternetAccess() {
        liveDataToObserve.value = listOfUsers
    }
}