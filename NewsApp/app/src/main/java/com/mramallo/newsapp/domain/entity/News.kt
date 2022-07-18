package com.mramallo.newsapp.domain.entity

data class News(
    val title: String,
    val content: String?,
    val description: String?,
    val author: String?,
    val url: String,
    val urlToImage: String,
)
