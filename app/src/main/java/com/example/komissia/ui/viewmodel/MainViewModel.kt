package com.example.komissia.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.komissia.data.model.Story
import com.example.komissia.data.model.StoryDetail
import com.example.komissia.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

// все возможные состояния списка — удобно обрабатывать через when
sealed interface ListScreenState {
    data object Loading : ListScreenState
    data class Content(val stories: List<Story>) : ListScreenState
    data class Error(val message: String) : ListScreenState
}

// аналогично для деталей
sealed interface DetailScreenState {
    data object Loading : DetailScreenState
    data class Content(val story: StoryDetail) : DetailScreenState
    data class Error(val message: String) : DetailScreenState
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    // три отдельных потока — собираем через combine в один стейт
    private val _stories = MutableStateFlow<List<Story>>(emptyList())
    private val _listError = MutableStateFlow<String?>(null)
    private val _isLoading = MutableStateFlow(true)

    // combine нужен чтобы при изменении любого потока
    // автоматом пересчитывался итоговый стейт экрана
    val listState: StateFlow<ListScreenState> = combine(
        _isLoading,
        _stories,
        _listError
    ) { loading, stories, error ->
        when {
            loading -> ListScreenState.Loading
            error != null -> ListScreenState.Error(error)
            else -> ListScreenState.Content(stories)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), ListScreenState.Loading)

    private val _detailState = MutableStateFlow<DetailScreenState>(DetailScreenState.Loading)
    val detailState: StateFlow<DetailScreenState> = _detailState

    init {
        loadStories()
    }

    fun loadStories() {
        viewModelScope.launch {
            // сначала сбрасываем ошибку — без этого retry не работал
            _isLoading.value = true
            _listError.value = null

            repository.loadStories()
                .onSuccess {
                    _stories.value = it
                    _isLoading.value = false
                }
                .onFailure {
                    _listError.value = it.message ?: "Что-то пошло не так"
                    _isLoading.value = false
                }
        }
    }

    fun loadStoryDetail(id: String) {
        viewModelScope.launch {
            _detailState.value = DetailScreenState.Loading

            repository.loadItem(id)
                .onSuccess { _detailState.value = DetailScreenState.Content(it) }
                .onFailure { _detailState.value = DetailScreenState.Error(it.message ?: "Ошибка") }
        }
    }
}
