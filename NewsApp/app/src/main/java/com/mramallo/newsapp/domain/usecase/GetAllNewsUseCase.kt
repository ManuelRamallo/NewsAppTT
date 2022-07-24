package com.mramallo.newsapp.domain.usecase

import com.mramallo.newsapp.data.repository.NewsRepository
import com.mramallo.newsapp.domain.entity.News
import javax.inject.Inject

class GetAllNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun  invoke() = repository.getAllNews("US")
}