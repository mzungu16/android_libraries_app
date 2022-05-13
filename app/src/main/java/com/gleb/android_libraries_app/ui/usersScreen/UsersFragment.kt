package com.gleb.android_libraries_app.ui.usersScreen

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gleb.android_libraries_app.R
import com.gleb.android_libraries_app.app
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersPojo
import com.gleb.android_libraries_app.databinding.UsersFragmentBinding
import com.gleb.android_libraries_app.domain.ProjectUsecase
import javax.inject.Inject

class UsersFragment : Fragment(), UsersAdapter.OnClickListener {
    private val binding by viewBinding(UsersFragmentBinding::class.java)
    private val allUsersAdapter = UsersAdapter(this)
    private val controller by lazy { activity as Controller }
    private var backColor = Color.WHITE

    @Inject
    lateinit var usersUsecase: ProjectUsecase.UsersUsecase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.users_fragment, container, false)
        backColor = savedInstanceState?.getInt("color") ?: Color.WHITE
        view.findViewById<RecyclerView>(R.id.users_recycler_view).setBackgroundColor(backColor)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireContext().app.daggerComponent.inject(this)
        val viewModel = ViewModelProvider(
            this,
            UsersViewModel(usersUsecase)
        ).get(UsersViewModel::class.java)

        initRecyclerView()

        //outgoing
        viewModel.showUsers()

        //incoming
        viewModel.users.observe(viewLifecycleOwner) {
            Log.d("TAG", "GET - $it")
            allUsersAdapter.usersList = it
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("color", backColor)
    }

    private fun initRecyclerView() {
        binding.usersRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = allUsersAdapter
        }
    }

    override fun onClick(position: Int) {
        val user = allUsersAdapter.usersList[position]
        backColor = Color.LTGRAY
        binding.usersRecyclerView.setBackgroundColor(backColor)
        Log.d("TAG", "Clicked $user")
        controller.showUserRepos(user)
    }

    interface Controller {
        fun showUserRepos(user: UsersPojo)
    }
}