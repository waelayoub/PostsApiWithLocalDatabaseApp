package com.example.homework4.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework4.databinding.ItemPostBinding
import com.example.homework4.model.PostData
import com.example.homework4.ui.PostViewModel

class PostsAdapter(var items:List<PostData>, private val viewModel: PostViewModel):RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {
    inner class PostsViewHolder(val binding: ItemPostBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(ItemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.binding.apply {
            tvTitle.text=items[position].title
            tvBody.text=items[position].body
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}