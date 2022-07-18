package com.mramallo.newsapp.domain.mapper

import com.mramallo.newsapp.data.NewsDto
import com.mramallo.newsapp.domain.entity.News

fun NewsDto.toNews() = News(
    title = title,
    content = content,
    description = description,
    author = author,
    url = url,
    urlToImage = urlToImage,
)