package com.example.homework4.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PostsTable")
data class PostData (@PrimaryKey @ColumnInfo(name = "Post_Id") val id:Int,
                     @ColumnInfo(name = "Post_title") var title:String,
                     @ColumnInfo(name = "Post_Body") var body:String)