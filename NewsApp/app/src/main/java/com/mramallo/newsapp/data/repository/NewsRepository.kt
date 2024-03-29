package com.mramallo.newsapp.data.repository

import com.mramallo.newsapp.data.api.NewsApi
import com.mramallo.newsapp.data.repository.extensions.safeBody
import com.mramallo.newsapp.domain.entity.News
import com.mramallo.newsapp.domain.mapper.toNews
import javax.inject.Inject

open class NewsRepository @Inject constructor(
    private val newsApi: NewsApi
) {

    private var news: List<News> = emptyList()

    open suspend fun getAllNews(country: String): List<News> {
        news = newsApi.topHeadlines(country).safeBody().articles?.map { it.toNews() } ?: emptyList()
        return news
    }

    open suspend fun getNew(title: String): News =
        news.first { it.title == title }

}