package com.mramallo.newsapp.data.repository.extensions

import retrofit2.Response

inline fun <reified T> Response<T>.safeBody(): T {
    if(isSuccessful) {
        body()?.let {
            return it
        }
    }

    throw Exception("Model ${T::class.java} is null")
}