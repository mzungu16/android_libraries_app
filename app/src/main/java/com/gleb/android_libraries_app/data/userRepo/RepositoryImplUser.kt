package com.gleb.android_libraries_app.data.userRepo

import androidx.lifecycle.MutableLiveData
import com.gleb.android_libraries_app.domain.AllUsersRepo

class RepositoryImplUser : AllUsersRepo.RepositoryUser {
    private val liveDataToObserve: MutableLiveData<List<Repos>> = MutableLiveData()
    private val reposList = listOf(
        Repos("sesattwwjw"),
        Repos("vebwpagzdq"),
        Repos("fedcxgqbmr"),
        Repos("aldaukubmp"),
        Repos("fvsipgbdpv"),
        Repos("xyfhhxkdau"),
        Repos("shehgqjswg"),
        Repos("sefjpswywq"),
        Repos("givrbpnedp"),
    )

    override fun getAllRepos() = liveDataToObserve

    override fun getInternetAccess() {
        liveDataToObserve.value = reposList
    }

}