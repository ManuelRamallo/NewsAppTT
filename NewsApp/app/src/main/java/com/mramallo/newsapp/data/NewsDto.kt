package com.mramallo.newsapp.data

import com.squareup.moshi.Json

data class NewsDto(
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "author") val author: String?,
    @Json(name = "url") val url: String,
    @Json(name = "urlToImage") val urlToImage: String,
)
