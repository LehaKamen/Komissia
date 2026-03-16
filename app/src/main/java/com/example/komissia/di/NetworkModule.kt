package com.example.komissia.di

import com.example.komissia.data.remote.ApiService
import com.example.komissia.data.remote.RetryInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
<<<<<<< HEAD
import javax.inject.Singleton

=======
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = "https://hn.algolia.com/api/v1/"
private const val CONNECT_TIMEOUT_SEC = 15L
private const val READ_TIMEOUT_SEC = 15L

>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
<<<<<<< HEAD
    fun provideRetryInterceptor(): RetryInterceptor {
        return RetryInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        retryInterceptor: RetryInterceptor
    ): OkHttpClient {

        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(retryInterceptor)
=======
    fun provideRetryInterceptor(): RetryInterceptor = RetryInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClient(retryInterceptor: RetryInterceptor): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        return OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT_SEC, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT_SEC, TimeUnit.SECONDS)
            .addInterceptor(retryInterceptor)
            .addInterceptor(logging)
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
            .build()
    }

    @Provides
    @Singleton
<<<<<<< HEAD
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://hn.algolia.com/api/v1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
=======
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
