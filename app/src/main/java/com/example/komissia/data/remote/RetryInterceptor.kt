package com.example.komissia.data.remote

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class RetryInterceptor(
    private val maxRetries: Int = 3
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()
        var response: Response? = null
        var tryCount = 0

        while (tryCount < maxRetries) {
            try {
                response = chain.proceed(request)

                if (response.isSuccessful) {
                    return response
                }

            } catch (e: IOException) {
                if (tryCount >= maxRetries - 1) {
                    throw e
                }
            }

            tryCount++
        }

        return response!!
    }
}