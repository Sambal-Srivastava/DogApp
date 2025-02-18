package com.app.dogapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.dogapp.data.repository.DogRepository
import com.app.dogapp.domain.usecase.ClearCachedImagesUseCase
import com.app.dogapp.domain.usecase.FetchRandomDogImageUseCase
import com.app.dogapp.domain.usecase.GetCachedImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(
    private val fetchRandomDogImageUseCase: FetchRandomDogImageUseCase,
    private val getCachedImagesUseCase: GetCachedImagesUseCase,
    private val clearCachedImagesUseCase: ClearCachedImagesUseCase
) : ViewModel() {
    private val _imageUrl = MutableStateFlow<String?>(null)
    val imageUrl: StateFlow<String?> = _imageUrl

    private val _cachedImages = MutableStateFlow<List<String>>(emptyList())
    val cachedImages: StateFlow<List<String>> = _cachedImages

    fun fetchRandomDogImage() {
        viewModelScope.launch {
            val url = fetchRandomDogImageUseCase()
            _imageUrl.value = url
        }
    }

    fun loadCachedImages() {
        _cachedImages.value = getCachedImagesUseCase()
    }

    fun clearCache() {
        clearCachedImagesUseCase()
        _cachedImages.value = emptyList()
    }
}