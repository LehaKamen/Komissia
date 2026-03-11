package com.example.komissia.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("search?tags=front_page")
    suspend fun getFrontPage(): StoryResponse

    @GET("items/{id}")
    suspend fun getItem(
        @Path("id") id: String
    ): StoryDto
}