package com.example.homework4.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.homework4.model.PostData

@Dao
interface PostDao {

    @Query("SELECT * FROM PostsTable")
    fun getPosts() : LiveData<List<PostData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(PostList:List<PostData>)
}