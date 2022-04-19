package com.gleb.android_libraries_app.ui.allUsersScreen

import androidx.lifecycle.*
import com.gleb.android_libraries_app.data.allUsersRepo.RepositoryImpl
import com.gleb.android_libraries_app.data.allUsersRepo.Users

class AllUsersViewModel(private val repo: RepositoryImpl) : ViewModel(), ViewModelProvider.Factory {
    private val liveDataToObserve: MutableLiveData<List<Users>> = MutableLiveData()
//    private val repo = RepositoryImpl()

    fun getLiveData(): LiveData<List<Users>> =
        Transformations.switchMap(liveDataToObserve) {
            repo.getAllUsersLiveData()
        }

    fun setLiveData() {
        liveDataToObserve.value = getLiveData().value
    }

    fun getInternet() {
        repo.getInternetAccess()
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllUsersViewModel(repo) as T
    }
}