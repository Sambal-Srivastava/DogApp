package com.app.dogapp.data.repository

import com.app.dogapp.data.remote.RetrofitClient
import javax.inject.Inject

class DogRepository @Inject constructor() {
    suspend fun fetchRandomDogImage(): String {
        val response = RetrofitClient.apiService.getRandomDogImage()
        return response.message
    }
}