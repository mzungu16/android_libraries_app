package com.gleb.android_libraries_app.ui.userScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.api.load
import com.gleb.android_libraries_app.R
import com.gleb.android_libraries_app.databinding.UserFragmentBinding
import com.gleb.android_libraries_app.domain.ProjectUsecase
import org.koin.android.ext.android.inject

class UserFragment : Fragment() {
    private val binding by viewBinding(UserFragmentBinding::class.java)
    private val userAdapter = UserAdapter()
    private val userUsecase: ProjectUsecase.UserUsecase by inject()

    companion object {
        private const val IMAGE_KEY = "image"
        private const val LOGIN_KEY = "login"
        fun newInstance(avatar: String, login: String): UserFragment {
            val args = Bundle()
            args.putString(IMAGE_KEY, avatar)
            args.putString(LOGIN_KEY, login)
            val fragment = UserFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val avatar = arguments?.getString(IMAGE_KEY)
        val login = arguments?.getString(LOGIN_KEY)
        val viewModel =
            ViewModelProvider(this, UserViewModel(userUsecase)).get(UserViewModel::class.java)
        binding.avatarImage.load(avatar)
        binding.userName.text = login
        initRecyclerView()

        //outgoing
        viewModel.showRepos(binding.userName.text.toString())

        //incoming
        viewModel.repos.observe(viewLifecycleOwner) {
            userAdapter.reposList = it
        }
    }

    private fun initRecyclerView() {
        binding.userRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }
    }
}
