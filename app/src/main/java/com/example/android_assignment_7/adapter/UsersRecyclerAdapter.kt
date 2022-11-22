package com.example.android_assignment_7.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assignment_7.R
import com.example.android_assignment_7.api.models.User

class UsersRecyclerAdapter : RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_card, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.findViewById<TextView>(R.id.name).text = "${user.firstName} ${user.lastName}"
        }
    }

    private var users: List<User> = emptyList()
}