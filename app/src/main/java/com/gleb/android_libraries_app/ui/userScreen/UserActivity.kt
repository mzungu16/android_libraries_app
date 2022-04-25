package com.gleb.android_libraries_app.ui.userScreen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.gleb.android_libraries_app.app
import com.gleb.android_libraries_app.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    private val viewModel: UserViewModel by viewModels { UserViewModel(app.userRepo) }
    private val userAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.userName.text = intent.getStringExtra("login")
        binding.avatarImage.load(intent.getStringExtra("image"))
        binding.userRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.userRecyclerview.adapter = userAdapter

        //outgoing
        viewModel.showRepos(binding.userName.text.toString())

        //incoming
        viewModel.repos.observe(this) {
            userAdapter.setList(it)
        }
    }
}
