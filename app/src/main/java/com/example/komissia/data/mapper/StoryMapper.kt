package com.example.komissia.data.mapper

import com.example.komissia.data.model.Story
import com.example.komissia.data.remote.StoryDto

fun StoryDto.toStory(): Story {
    return Story(
        id = objectID,
        title = title ?: "No title",
        author = author,
        url = url
    )
}