package com.example.komissia.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.komissia.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.komissia.data.remote.StoryDto
import com.example.komissia.data.model.Story
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _stories = MutableStateFlow<List<Story>>(emptyList())
    val stories: StateFlow<List<Story>> = _stories

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _selectedStory = MutableStateFlow<StoryDto?>(null)
    val selectedStory: StateFlow<StoryDto?> = _selectedStory

    fun loadStories() {

        viewModelScope.launch {

            val result = repository.loadStories()

            result.fold(
                onSuccess = {
                    _stories.value = it
                },
                onFailure = {
                    _error.value = it.message
                }
            )
        }
    }
    fun loadStoryDetail(id: String) {

        viewModelScope.launch {

            val result = repository.loadItem(id)

            result.fold(
                onSuccess = {
                    _selectedStory.value = it
                },
                onFailure = {
                    _error.value = it.message
                }
            )

        }
    }
}