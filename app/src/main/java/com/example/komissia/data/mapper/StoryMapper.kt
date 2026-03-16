package com.example.komissia.data.mapper

import com.example.komissia.data.model.Story
import com.example.komissia.data.model.StoryDetail
import com.example.komissia.data.remote.ItemDto
import com.example.komissia.data.remote.StoryDto

// маппер для списка — из поискового дто в доменную модель
fun StoryDto.toStory(): Story = Story(
    id = objectID,
    title = title ?: "No title",
    author = author,
    url = url
)

// маппер для деталей — из дто айтема в доменную модель
// тут id число а в доменной модели строка, поэтому конвертим
fun ItemDto.toStoryDetail(): StoryDetail = StoryDetail(
    id = id.toString(),
    title = title ?: "No title",
    author = author,
    url = url,
    points = points,
    text = text
)
