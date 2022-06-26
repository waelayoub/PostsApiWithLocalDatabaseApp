package com.example.homework4.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework4.databinding.ActivityMainBinding
import com.example.homework4.db.PostDatabase
import com.example.homework4.repository.PostRepository
import com.example.homework4.ui.utils.PostsAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

         val database by lazy {
            PostDatabase.createDatabase(this)
        }

         val repository by lazy {
            PostRepository(database.getPostDao())
        }
        val factory by lazy {
            PostViewModelFactory(repository)
        }
        val viewModel by lazy{
            ViewModelProvider(this, factory).get(PostViewModel::class.java)
        }

        val postsAdapter = PostsAdapter(listOf(),viewModel)

        binding.rvPosts.layoutManager=LinearLayoutManager(this)
        binding.rvPosts.adapter=postsAdapter

        viewModel.postsList.observe(this,{postsItems->
            postsAdapter.items=postsItems
            postsAdapter.notifyDataSetChanged()
        })

    }
}