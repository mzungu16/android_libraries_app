package com.gleb.android_libraries_app.ui.userScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import coil.api.load
import com.gleb.android_libraries_app.app
import com.gleb.android_libraries_app.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel =
            ViewModelProvider(this, UserViewModel(app.userRepo)).get(UserViewModel::class.java)
        val userAdapter = UserAdapter()
        val login = intent.getStringExtra("login")
        val image = intent.getStringExtra("image")

        binding.userName.text = login
        binding.avatarImage.load(image)

        viewModel.getLiveDataFromRepo().observe(this) {
            userAdapter.setList(it)
        }
        viewModel.setLiveData()
        viewModel.getInternet()

        binding.userRecyclerview.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        binding.userRecyclerview.adapter = userAdapter
    }
}