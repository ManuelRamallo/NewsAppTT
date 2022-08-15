package com.mramallo.newsapp.data.api

import com.mramallo.newsapp.data.NewsApiResponseDto
import com.mramallo.newsapp.utils.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines?apiKey=$API_KEY")
    suspend fun topHeadlines(@Query("country") country: String): Response<NewsApiResponseDto>


}