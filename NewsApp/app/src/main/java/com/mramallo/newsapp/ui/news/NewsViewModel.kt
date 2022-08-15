package com.mramallo.newsapp.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mramallo.newsapp.domain.entity.News
import com.mramallo.newsapp.domain.usecase.GetAllNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getAllNewsUseCase: GetAllNewsUseCase
) : ViewModel() {

    private val _news = MutableLiveData<List<News>>()

    fun getAllNews(): LiveData<List<News>> {
        viewModelScope.launch(Dispatchers.IO) {
            val news = getAllNewsUseCase()
            _news.postValue(news)
        }

        return _news
    }

}