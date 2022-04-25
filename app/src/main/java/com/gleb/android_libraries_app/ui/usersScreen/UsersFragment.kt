package com.gleb.android_libraries_app.ui.usersScreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gleb.android_libraries_app.R
import com.gleb.android_libraries_app.app
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersPojo
import com.gleb.android_libraries_app.databinding.UsersFragmentBinding

class UsersFragment : Fragment(), UsersAdapter.OnClickListener {
    private val binding by viewBinding(UsersFragmentBinding::class.java)
    private val allUsersAdapter = UsersAdapter(this)
    private val controller by lazy { activity as Controller }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.users_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val app = requireContext().app
        val viewModel = ViewModelProvider(
            this,
            UsersViewModel(app.usersUsecase)
        ).get(UsersViewModel::class.java)

        initRecyclerView()

        //outgoing
        viewModel.showUsers()

        //incoming
        viewModel.users.observe(viewLifecycleOwner) {
            allUsersAdapter.usersList = it
        }

    }

    private fun initRecyclerView() {
        binding.usersRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = allUsersAdapter
        }
    }

    override fun onClick(position: Int) {
        val user = allUsersAdapter.usersList[position]
        Log.d("TAG","Clicked $user")
        controller.showUserRepos(user)
    }

    interface Controller {
        fun showUserRepos(user: UsersPojo)
    }
}