package com.gleb.android_libraries_app.ui.allUsersScreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.gleb.android_libraries_app.app
import com.gleb.android_libraries_app.databinding.ActivityMainBinding
import com.gleb.android_libraries_app.ui.userScreen.UserActivity

class AllUsersActivity : AppCompatActivity(), AllUsersAdapter.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val allUsersAdapter = AllUsersAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerView = binding.mainRecyclerView
        val viewModel =
            ViewModelProvider(this, AllUsersViewModel(app.repo)).get(AllUsersViewModel::class.java)

        viewModel.getLiveData().observe(this) {
            allUsersAdapter.setList(it)
        }
        viewModel.setLiveData()
        viewModel.getInternet()

        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = allUsersAdapter
    }

    override fun onClick(position: Int) {
        val user = allUsersAdapter.usersList[position]
        Log.d("TAG", "Clicked ${user.login}")
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra("image", user.image)
        intent.putExtra("login", user.login)
        startActivity(intent)
    }
}