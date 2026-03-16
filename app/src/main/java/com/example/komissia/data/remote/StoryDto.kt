package com.example.komissia.data.remote

// дто для результатов поиска (/search) — тут приходит objectID строкой
data class StoryDto(
    val objectID: String,
    val title: String?,
    val author: String?,
    val url: String?
)
