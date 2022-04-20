package com.gleb.android_libraries_app.ui.userScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gleb.android_libraries_app.R
import com.gleb.android_libraries_app.data.userRepo.DiffCallBackRepo
import com.gleb.android_libraries_app.data.userRepo.Repos

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var reposList: List<Repos> = listOf()

    fun setList(reposListParam: List<Repos>) {
        val diffCallBack = DiffCallBackRepo(this.reposList, reposListParam)
        DiffUtil.calculateDiff(diffCallBack).also { diffResult ->
            diffResult.dispatchUpdatesTo(this)
        }
        reposList = reposListParam
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_screen_recyclerview_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding(reposList[position])
    }

    override fun getItemCount() = reposList.size

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val repoName = view.findViewById<TextView>(R.id.repo_name)
        fun binding(item: Repos) {
            repoName.text = item.text
        }
    }
}
