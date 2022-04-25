package com.gleb.android_libraries_app.ui.usersScreen

import androidx.lifecycle.*
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersPojo
import com.gleb.android_libraries_app.domain.ProjectUsecase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UsersViewModel(private val usecase: ProjectUsecase.UsersUsecase) : ViewModel(),
    ViewModelProvider.Factory {
    private val compDisposable = CompositeDisposable()
    private val _users = MutableLiveData<List<UsersPojo>>()
    val users: LiveData<List<UsersPojo>> = _users

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(usecase) as T
    }

    fun showUsers() {
        compDisposable.add(
            usecase.data.observeUsers().subscribeBy {
                _users.postValue(it)
            }
        )
    }

    override fun onCleared() {
        compDisposable.clear()
        super.onCleared()
    }
}