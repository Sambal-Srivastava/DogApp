package com.app.dogapp.domain.usecase

import com.app.dogapp.data.repository.DogRepository
import javax.inject.Inject

class ClearCachedImagesUseCase @Inject constructor(private val repository: DogRepository) {
    operator fun invoke() {
        repository.clearCache()
    }
}