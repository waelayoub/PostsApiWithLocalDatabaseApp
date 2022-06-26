package com.example.homework4.repository

import androidx.lifecycle.LiveData
import com.example.homework4.db.PostDao
import com.example.homework4.model.PostData
import com.example.homework4.service.PostApiNetwork

class PostRepository(private val postDao: PostDao){

    val postList:LiveData<List<PostData>> = postDao.getPosts()

    suspend fun refreshPosts(){

        val newPostData=PostApiNetwork.serviceApi.getPosts()
        postDao.insertPosts(newPostData)
    }
}