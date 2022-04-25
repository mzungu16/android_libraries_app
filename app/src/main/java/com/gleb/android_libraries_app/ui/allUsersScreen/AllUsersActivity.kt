package com.gleb.android_libraries_app.ui.allUsersScreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.gleb.android_libraries_app.app
import com.gleb.android_libraries_app.databinding.ActivityMainBinding
import com.gleb.android_libraries_app.ui.userScreen.UserActivity

class AllUsersActivity : AppCompatActivity(), AllUsersAdapter.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: AllUsersViewModel by viewModels { AllUsersViewModel(app.usersRepo) }
    private val allUsersAdapter = AllUsersAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerView.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        binding.mainRecyclerView.adapter = allUsersAdapter

        //outgoing
        viewModel.showUsers()

        //incoming
        viewModel.users.observe(this) {
            allUsersAdapter.setList(it)
        }
    }

    override fun onClick(position: Int) {
        val user = allUsersAdapter.usersList[position]
        Log.d("TAG", "Clicked ${user.login}")
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra("image", user.avatar_url)
        intent.putExtra("login", user.login)
        startActivity(intent)
    }
}