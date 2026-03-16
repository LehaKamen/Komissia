package com.example.komissia.data.remote

// дто для эндпоинта /items/{id} — тут id приходит числом а не строкой как в поиске
data class ItemDto(
    val id: Int,
    val title: String?,
    val author: String?,
    val url: String?,
    val points: Int?,
    val text: String?
)
