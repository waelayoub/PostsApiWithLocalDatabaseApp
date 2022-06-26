package com.example.homework4.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.homework4.repository.PostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository):ViewModel(){
    init {
        refreshPosts()
    }

    val postsList=postRepository.postList

    private fun refreshPosts(){
        CoroutineScope(Dispatchers.IO).launch {
            postRepository.refreshPosts()
        }
    }
}

class PostViewModelFactory(private val postRepository: PostRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }

}