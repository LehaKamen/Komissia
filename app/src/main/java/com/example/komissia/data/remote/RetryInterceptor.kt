package com.example.komissia.data.remote

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

private const val AUTO_RETRY_COUNT = 1
private const val RETRY_DELAY_MS = 2000L

// MOD_D18: при ошибке сети — 1 автоматический повтор через 2 секунды
// если и повтор не сработал — ошибка пробрасывается наверх
// и ViewModel показывает кнопку Retry пользователю
class RetryInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        var lastException: IOException? = null

        for (attempt in 0..AUTO_RETRY_COUNT) {
            try {
                val response = chain.proceed(request)
                if (response.isSuccessful) return response

                // сервер ответил но с ошибкой — если есть ещё попытка, закрываем и пробуем снова
                if (attempt < AUTO_RETRY_COUNT) {
                    response.close()
                    Thread.sleep(RETRY_DELAY_MS)
                } else {
                    return response
                }
            } catch (e: IOException) {
                lastException = e
                if (attempt < AUTO_RETRY_COUNT) {
                    Thread.sleep(RETRY_DELAY_MS)
                }
            }
        }

        throw lastException ?: IOException("Запрос не удался после автоповтора")
    }
}
