package com.gleb.android_libraries_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersPojo
import com.gleb.android_libraries_app.databinding.ActivityMainBinding
import com.gleb.android_libraries_app.ui.userScreen.UserFragment
import com.gleb.android_libraries_app.ui.usersScreen.UsersFragment

class MainActivity : AppCompatActivity(), UsersFragment.Controller {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(binding.usersContainer.id, UsersFragment())
                .commit()
        }
    }

    override fun showUserRepos(user: UsersPojo) {
        val userFragment = UserFragment.newInstance(user.avatar_url, user.login)
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(binding.reposContainer.id, userFragment)
            .commit()
    }
}
