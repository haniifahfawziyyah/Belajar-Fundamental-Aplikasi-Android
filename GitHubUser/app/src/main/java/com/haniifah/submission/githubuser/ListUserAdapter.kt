package com.haniifah.submission.githubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListUserAdapter (private val users: ArrayList<UserData>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>(){

    private lateinit var onItemClickDetail: OnItemClickCallBack

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallBack) {
        this.onItemClickDetail = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = users[position]
        holder.imgAvatar.setImageResource(user.avatar)
        holder.tvName.text = user.name
        holder.tvUsername.text = user.username
        holder.tvLocation.text = user.location
        holder.itemView.setOnClickListener { onItemClickDetail.onItemClicked(users[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = users.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_item_avatar)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_item_location)
    }

    interface OnItemClickCallBack {
        fun onItemClicked(data: UserData)
    }
}