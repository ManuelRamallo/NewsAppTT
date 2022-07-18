package com.mramallo.newsapp.data

import com.squareup.moshi.Json

data class NewsApiResponseDto(
    @Json(name = "status") val status: String? = null,
    @Json(name = "code") val code: String? = null,
    @Json(name = "articles") val articles: List<NewsDto>? = null
)
