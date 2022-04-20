package com.gleb.android_libraries_app.ui.allUsersScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.gleb.android_libraries_app.app
import com.gleb.android_libraries_app.databinding.ActivityMainBinding

class AllUsersActivity : AppCompatActivity(), AllUsersAdapter.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val allUsersAdapter = AllUsersAdapter()
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
        //todo
    }
}