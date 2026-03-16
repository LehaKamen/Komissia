package com.example.komissia.data.repository

<<<<<<< HEAD
import com.example.komissia.data.remote.ApiService
import com.example.komissia.data.remote.StoryDto
import javax.inject.Inject
import com.example.komissia.data.mapper.toStory
import com.example.komissia.data.model.Story
=======
import com.example.komissia.data.mapper.toStory
import com.example.komissia.data.mapper.toStoryDetail
import com.example.komissia.data.model.Story
import com.example.komissia.data.model.StoryDetail
import com.example.komissia.data.remote.ApiService
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {

<<<<<<< HEAD
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
=======
    suspend fun loadStories(): Result<List<Story>> = safeCall {
        apiService.getFrontPage().hits.map { it.toStory() }
    }

    // возвращаем StoryDetail а не ItemDto — дто не должен уходить дальше репозитория
    suspend fun loadItem(id: String): Result<StoryDetail> = safeCall {
        apiService.getItem(id).toStoryDetail()
    }

    // обёртка чтобы не дублировать try-catch
    // CancellationException пробрасываем дальше чтобы не ломать корутины
    private inline fun <T> safeCall(block: () -> T): Result<T> = try {
        Result.success(block())
    } catch (ce: CancellationException) {
        throw ce
    } catch (e: Exception) {
        Result.failure(e)
    }
}
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
