package com.app.dogapp.domain.usecase

import com.app.dogapp.data.repository.DogRepository
import javax.inject.Inject

class GetCachedImagesUseCase @Inject constructor(private val repository: DogRepository) {

    operator fun invoke(): List<String> {
        return repository.getCachedImages()
    }
}