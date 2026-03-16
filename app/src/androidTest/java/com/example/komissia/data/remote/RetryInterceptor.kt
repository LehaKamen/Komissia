package com.example.komissia.data.remote

import okhttp3.Interceptor
import okhttp3.Response
import kotlinx.coroutines.delay

class RetryInterceptor(
    private val maxRetries: Int = 1
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var attempt = 0
        var response: Response

        while (true) {
            try {
                response = chain.proceed(chain.request())

                if (response.isSuccessful || attempt >= maxRetries) {
                    return response
                }

            } catch (e: Exception) {
                if (attempt >= maxRetries) {
                    throw e
                }
            }

            attempt++
            Thread.sleep(2000)
        }
    }
}