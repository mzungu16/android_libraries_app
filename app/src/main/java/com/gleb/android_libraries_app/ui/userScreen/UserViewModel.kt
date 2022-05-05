package com.gleb.android_libraries_app.ui.userScreen

import androidx.lifecycle.*
import com.gleb.android_libraries_app.data.userRepo.retrofit2.ReposPojo
import com.gleb.android_libraries_app.domain.ProjectUsecase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UserViewModel(private val usecase: ProjectUsecase.UserUsecase) : ViewModel(),
    ViewModelProvider.Factory {

    private val compDisposable = CompositeDisposable()
    private val _repos = MutableLiveData<List<ReposPojo>>()
    val repos: LiveData<List<ReposPojo>> = _repos

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(usecase) as T
    }

    fun showRepos(userName: String) {
        compDisposable.add(
            usecase.data.observeUsersRepo(userName).subscribeBy {
                _repos.postValue(it)
            }
        )
    }

    override fun onCleared() {
        compDisposable.clear()
        super.onCleared()
    }
}
