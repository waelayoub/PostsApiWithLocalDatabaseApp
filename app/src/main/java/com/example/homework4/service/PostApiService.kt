package com.example.homework4.service

import com.example.homework4.model.PostData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL:String="https://jsonplaceholder.typicode.com"


interface PostApiService {
    @GET("/posts")
    suspend fun getPosts():List<PostData>
}

object PostApiNetwork{
    private val retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val serviceApi= retrofit.create(PostApiService::class.java)
}