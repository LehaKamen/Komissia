package com.example.komissia.data.repository

import com.example.komissia.data.remote.ApiService
import com.example.komissia.data.remote.StoryDto
import javax.inject.Inject
import com.example.komissia.data.mapper.toStory
import com.example.komissia.data.model.Story

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun loadStories(): Result<List<Story>> {
        return try {
            val response = apiService.getFrontPage()
            val stories = response.hits.map { it.toStory() }
            Result.success(stories)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    suspend fun loadItem(id: String): Result<StoryDto> {
        return try {
            val response = apiService.getItem(id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)

        }
    }
}