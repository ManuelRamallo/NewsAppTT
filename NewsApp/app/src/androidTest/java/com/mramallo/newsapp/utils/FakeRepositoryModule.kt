package com.mramallo.newsapp.utils

import com.mramallo.newsapp.data.api.NewsApi
import com.mramallo.newsapp.data.repository.NewsRepository
import com.mramallo.newsapp.di.ProviderModule
import com.mramallo.newsapp.domain.entity.News
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ProviderModule::class]
)

class FakeRepositoryModule {

    @Provides
    @Singleton
    fun providerNewsRepository(newsApi: NewsApi): NewsRepository =
        object : NewsRepository(newsApi) {
            val news = arrayListOf(
                News("Title1", "content1", "description1", "author1", "url1", "urlToImage1"),
                News("Title2", "content2", "description2", "author2", "url2", "urlToImage2")
            )

            override suspend fun getAllNews(country: String): List<News> = news
            override suspend fun getNew(title: String): News = news[0]

        }

}