package com.gleb.android_libraries_app.ui.allUsersScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.gleb.android_libraries_app.R
import com.gleb.android_libraries_app.data.allUsersRepo.DiffCallBackUsers
import com.gleb.android_libraries_app.data.allUsersRepo.Users

class AllUsersAdapter(private val onClickListener: OnClickListener) :
    RecyclerView.Adapter<AllUsersAdapter.MainViewHolder>() {
    var usersList: List<Users> = listOf()

    fun setList(usersListParam: List<Users>) {
        val diffCallBack = DiffCallBackUsers(this.usersList, usersListParam)
        DiffUtil.calculateDiff(diffCallBack).also { diffResult ->
            diffResult.dispatchUpdatesTo(this)
        }
        usersList = usersListParam
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_screen_recyclerview_item, parent, false)
        return MainViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding(usersList[position])
    }

    override fun getItemCount() = usersList.size

    inner class MainViewHolder(view: View, private val onClickListener: OnClickListener) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
        private val avatar = view.findViewById<ImageView>(R.id.user_avatar)
        private val login = view.findViewById<TextView>(R.id.user_name)

        init {
            itemView.setOnClickListener(this)
        }

        fun binding(item: Users) {
            avatar.load(item.image)
            login.text = item.login
        }

        override fun onClick(p0: View?) {
            onClickListener.onClick(adapterPosition)
        }
    }

    interface OnClickListener {
        fun onClick(position: Int)
    }

}