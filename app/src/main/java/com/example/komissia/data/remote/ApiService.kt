package com.example.komissia.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    // список новостей с главной страницы
    @GET("search?tags=front_page")
    suspend fun getFrontPage(): StoryResponse

    // детали одной статьи — возвращает ItemDto а не StoryDto
    // потому что /items/{id} отдаёт другую структуру (id число, а не objectID строка)
    @GET("items/{id}")
    suspend fun getItem(
        @Path("id") id: String
    ): ItemDto
}
