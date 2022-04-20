package com.gleb.android_libraries_app.ui.userScreen

import androidx.lifecycle.*
import com.gleb.android_libraries_app.data.userRepo.Repos
import com.gleb.android_libraries_app.data.userRepo.RepositoryImplUser

class UserViewModel(private val repo: RepositoryImplUser) : ViewModel(), ViewModelProvider.Factory {
    private val liveDataToObserve: MutableLiveData<List<Repos>> = MutableLiveData()

    fun getLiveDataFromRepo(): LiveData<List<Repos>> =
        Transformations.switchMap(liveDataToObserve) {
            repo.getAllRepos()
        }

    fun setLiveData() {
        liveDataToObserve.value = getLiveDataFromRepo().value
    }

    fun getInternet() {
        repo.getInternetAccess()
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(repo) as T
    }
}