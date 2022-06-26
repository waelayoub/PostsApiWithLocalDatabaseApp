package com.example.homework4.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.homework4.model.PostData


@Database(entities = [PostData::class], version = 1)
abstract class PostDatabase: RoomDatabase() {

    abstract fun getPostDao():PostDao

    companion object{
        @Volatile
        private var INSTANCE:PostDatabase?=null
        fun createDatabase(context: Context):PostDatabase{
            return INSTANCE?:synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostDatabase::class.java,
                    "Post.db")
                    .build()
                INSTANCE=instance
                instance
            }
        }
    }

}