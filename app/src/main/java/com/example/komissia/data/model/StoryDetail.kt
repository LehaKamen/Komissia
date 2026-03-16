package com.example.komissia.data.model

// доменная модель для экрана деталей — дто сюда не попадает
data class StoryDetail(
    val id: String,
    val title: String,
    val author: String?,
    val url: String?,
    val points: Int?,
    val text: String?
)
