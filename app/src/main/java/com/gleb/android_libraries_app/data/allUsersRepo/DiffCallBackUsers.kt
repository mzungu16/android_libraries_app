package com.gleb.android_libraries_app.data.allUsersRepo

import androidx.recyclerview.widget.DiffUtil
import com.gleb.android_libraries_app.data.allUsersRepo.retrofit.UsersPojo

class DiffCallBackUsers(
    private val oldList: List<UsersPojo>,
    private val newList: List<UsersPojo>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}