package com.app.dogapp.domain.usecase

import com.app.dogapp.data.repository.DogRepository
import javax.inject.Inject

class FetchRandomDogImageUseCase @Inject constructor(private val repository: DogRepository) {

    suspend operator fun invoke(): String {
        val imageUrl = repository.fetchRandomDogImage()
        repository.saveImageToCache(imageUrl)
        return imageUrl
    }
}