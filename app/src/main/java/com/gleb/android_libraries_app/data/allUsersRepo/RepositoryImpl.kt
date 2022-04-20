package com.gleb.android_libraries_app.data.allUsersRepo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gleb.android_libraries_app.domain.AllUsersRepo

class RepositoryImpl : AllUsersRepo.Repository {
    private val liveDataToObserve: MutableLiveData<List<Users>> = MutableLiveData()
    private val listOfUsers = listOf(
        Users("login1", "https://i.pravatar.cc/500?img=1"),
        Users("login2", "https://i.pravatar.cc/500?img=2"),
        Users("login3", "https://i.pravatar.cc/500?img=3"),
        Users("login4", "https://i.pravatar.cc/500?img=4"),
        Users("login5", "https://i.pravatar.cc/500?img=5"),
        Users("login6", "https://i.pravatar.cc/500?img=6"),
        Users("login7", "https://i.pravatar.cc/500?img=7"),
        Users("login8", "https://i.pravatar.cc/500?img=8"),
        Users("login9", "https://i.pravatar.cc/500?img=9"),
        Users("login10", "https://i.pravatar.cc/500?img=10"),
        Users("login11", "https://i.pravatar.cc/500?img=11"),
        Users("login12", "https://i.pravatar.cc/500?img=12"),
        Users("login13", "https://i.pravatar.cc/500?img=13"),
        Users("login14", "https://i.pravatar.cc/500?img=14"),
        Users("login15", "https://i.pravatar.cc/500?img=15"),
        Users("login16", "https://i.pravatar.cc/500?img=16"),
    )

    override fun getAllUsersLiveData(): LiveData<List<Users>> {
        return liveDataToObserve
    }

    override fun getInternetAccess() {
        liveDataToObserve.value = listOfUsers
    }
}