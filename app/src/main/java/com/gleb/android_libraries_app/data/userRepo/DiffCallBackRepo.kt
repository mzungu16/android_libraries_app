package com.gleb.android_libraries_app.data.userRepo

import androidx.recyclerview.widget.DiffUtil
import com.gleb.android_libraries_app.data.userRepo.retrofit2.ReposPojo

class DiffCallBackRepo(
    private val oldList: List<ReposPojo>,
    private val newList: List<ReposPojo>
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
