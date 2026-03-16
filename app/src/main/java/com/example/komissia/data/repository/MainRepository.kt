package com.example.komissia.data.repository

import com.example.komissia.data.mapper.toStory
import com.example.komissia.data.mapper.toStoryDetail
import com.example.komissia.data.model.Story
import com.example.komissia.data.model.StoryDetail
import com.example.komissia.data.remote.ApiService
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {

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
