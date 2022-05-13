package com.gleb.android_libraries_app.di

import com.gleb.android_libraries_app.ui.userScreen.UserFragment
import com.gleb.android_libraries_app.ui.usersScreen.UsersFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DaggerModule::class
    ]
)
interface DaggerComponent {
    fun inject(usersFragment: UsersFragment)
    fun injectU(userFragment: UserFragment)
}