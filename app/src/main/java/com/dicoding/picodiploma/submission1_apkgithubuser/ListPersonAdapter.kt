package com.dicoding.picodiploma.submission1_apkgithubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ListPersonAdapter(val listPerson:ArrayList<Person>) : RecyclerView.Adapter<ListPersonAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: Any) {
        this.onItemClickCallback = onItemClickCallback as OnItemClickCallback
    }
    class ListViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var imgAvatar : ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvUsername : TextView = itemView.findViewById(R.id.tv_item_username)
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
    }

    interface OnItemClickCallback {
        abstract fun onItemClicked(data: Person)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_person, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (username,name,avatar) = listPerson[position]
        holder.imgAvatar.setImageResource(avatar)
        holder.tvUsername.text = username
        holder.tvName.text = name
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listPerson[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPerson[holder.adapterPosition]) }
        }
    }

    override fun getItemCount(): Int = listPerson.size


}

interface OnItemClickCallback {
    abstract fun onItemClicked(data: Person)

}
