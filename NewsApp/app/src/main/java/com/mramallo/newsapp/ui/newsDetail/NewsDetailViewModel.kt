package com.mramallo.newsapp.ui.newsDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mramallo.newsapp.data.repository.NewsRepository
import com.mramallo.newsapp.domain.entity.News
import com.mramallo.newsapp.domain.usecase.GetAllNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsDetailViewModel @Inject constructor(
    private val getAllNewsUseCase: GetAllNewsUseCase
): ViewModel() {

    val _news = MutableLiveData<List<News>>()

    fun getNews(){
        viewModelScope.launch(Dispatchers.IO) {
            val news = getAllNewsUseCase()
            _news.postValue(news)
        }
    }

}